package Test;

import Pages.RightHomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRightHome {


    private static CSVWriter writer;
    private static WebDriver driver;
    private static final String CSV_FILE_PATH = "F:/AiWorkSquad/TestResults/TestRighHome.csv"; // Specify the absolute path to your folder

    public static void main(String[] args) {
        try {

            ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless");



            // Initialize WebDriver (ChromeDriver)
            driver = new ChromeDriver(options);
            Dimension dimension = new Dimension(1920, 1080);
            driver.manage().window().setSize(dimension);
           // driver.manage().window().maximize();

            boolean fileExists = new File(CSV_FILE_PATH).exists();
            // Create a CSV file writer
            writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));

            if (!fileExists) {
                writer.writeNext(new String[]{"Date", "Time", "Test Name", "Status"});
            }

            // Test methods
            testPrompts();
            testimgGeneration();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser and CSV writer after the test completes
            if (driver != null) {
                driver.quit();
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static void writeTestResult(String testName, String status) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format date and time
        String formattedDate = now.format(formatter);

        // Write test result to CSV file
        writer.writeNext(new String[]{formattedDate.split(" ")[0], formattedDate.split(" ")[1], testName, status});
    }

    public static void testPrompts() {
        try {
            System.out.println("Testing the prompt window");
            // Test logic for prompts

            driver.get("https://aiworksquad.com/login");

            // Create an instance of the LoginPage class
            LoginPage loginPage = new LoginPage(driver);

            // Enter valid email and password

            loginPage.enterEmail("omendra108@gmail.com");
            loginPage.enterPassword("1234");
            loginPage.clickLogin();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("chat")); // Wait until URL contains "chat"

            // Create an instance of the class
            RightHomePage page = new RightHomePage(driver);

            page.ClickPrompt();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(RightHomePage.getSalesOperations()));

            // Add assertions to verify successful
            assert RightHomePage.PromptVerified().equals("Sales Operations and Optimization") : "Error message is incorrect";
            System.out.println("Prompt_exists_completed");

            WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Sales Operations and Optimization']")));

            page.ClickSalesOperation();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(RightHomePage.salesplanLocator()));

            assert RightHomePage.SalesOperationverified().equals("Sales Planning and Forecasting") : "Error message is incorrect";
            System.out.println("SalesOperation_exists_completed");

            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Sales Operations and Optimization']")));


            page.ClickSalesOperationback();

            WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Sales Training']")));

            page.ClickSalesTraining();

            WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait5.until(ExpectedConditions.visibilityOfElementLocated(RightHomePage.salesTrainLocator()));

            assert RightHomePage.SalesTrainingVerified().equals("Sales Training and Onboarding") : "Error message is incorrect";
            System.out.println("SalesTraining_exists_completed");

            WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Sales Training']")));

            page.ClickSalesTrainingback();

            WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Sales Technology']")));

            page.ClickSalesTechnology();

            WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait8.until(ExpectedConditions.visibilityOfElementLocated(RightHomePage.salesTechLocator()));

            assert RightHomePage.SalesTechVerified().equals("CRM Implementation and Management") : "Error message is incorrect";
            System.out.println("SalesTech_exists_completed");

            // Write test result to CSV file
            writeTestResult("Prompts", "Passed");


        } catch (Exception e) {
            System.err.println("An error occurred in testPrompts: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Prompts", "Failed");
        }
    }

    public static void testimgGeneration() {
        try {
            System.out.println("Testing the image generation window");
            // Test logic for image generation

            driver.get("https://aiworksquad.com/login");

            // Create an instance of the LoginPage class
            LoginPage loginPage = new LoginPage(driver);

            // Enter valid email and password

            loginPage.enterEmail("omendra108@gmail.com");
            loginPage.enterPassword("1234");
            loginPage.clickLogin();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("chat")); // Wait until URL contains "chat"

            // Create an instance of the class
            RightHomePage page1 = new RightHomePage(driver);

            page1.ClickImageGenerator();

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control']")));

            RightHomePage.enterimage("hello");

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Generate']")));

            page1.ClickImageGenerator();

            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img)[2]")));

            // Write test result to CSV file
            writeTestResult("Image Generation", "Passed");


        } catch (Exception e) {
            System.err.println("An error occurred in testimgGeneration: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Image Generation", "Failed");

        }


    }
}

