package Test;
import Pages.LoginPage;
import Pages.MainHome;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestMainHome {
    private static WebDriver driver; // Moved the driver declaration here
    private static CSVWriter writer;
    private static final String CSV_FILE_PATH = "F:/javaselenium/TestResults/TestChat.csv";

    public static void main(String[] args) {
        try {
            // Initialize WebDriver (ChromeDriver)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Enable headless mode

            // Create a new instance of the ChromeDriver with headless options
            driver = new ChromeDriver(options); // Assign to class-level static variable driver
            driver.manage().window().maximize();

            boolean fileExists = new File(CSV_FILE_PATH).exists();
            // Create a CSV file writer
            writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));

            if (!fileExists) {
                writer.writeNext(new String[]{"Date", "Time", "Test Name", "Status"});
            }

            // Test methods
            testCorrectChat();


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

    // Remaining code remains the same...


    private static void writeTestResult(String testName, String status) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format date and time
        String formattedDate = now.format(formatter);

        // Write test result to CSV file
        writer.writeNext(new String[]{formattedDate.split(" ")[0], formattedDate.split(" ")[1], testName, status});
    }

    public static void testCorrectChat() {
        try {
            // Navigate to the login page


            driver.get("https://aiworksquad.com/login");

            // Create an instance of the LoginPage class
            LoginPage loginPage = new LoginPage(driver);

            // Enter valid email and password
            loginPage.enterEmail("omendra108@gmail.com");
            loginPage.enterPassword("1234");
            loginPage.clickLogin();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("chat"));
            // Create an instance of the LoginPage class

            MainHome MainPage = new MainHome(driver);



            MainPage.ClicknewChat();

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='border input-group']//input[@placeholder='Enter your query here...']")));
            MainPage.clickchat();
            // Enter valid email and password
            MainHome.enterchat(" How do you identify and prioritize target market segments for our sales plan?");
            MainPage.clicksend();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mx-1 p-3'])[1]")));


            // Write test result to CSV file
            writeTestResult("Workingchat", "Passed");
            System.out.println("pass_correct_Chat");

        } catch (Exception e) {
            System.err.println("Error occurred: on correct chat " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Workingchat", "Failed");
        }
    }
}

