package Test;
import Pages.LoginPage;
import com.opencsv.CSVWriter;
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

public class TestLogin {
    private static WebDriver driver; // Moved the driver declaration here
    private static CSVWriter writer;
    private static final String CSV_FILE_PATH = "F:/javaselenium/TestResults/TestLogin.csv";

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
            testCorrectCredentials();
            testIncorrectCredentials();

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

    // Test with correct credentials
    public static void testCorrectCredentials() {
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
            wait.until(ExpectedConditions.urlContains("chat")); // Wait until URL contains "chat"

            // Add assertions to verify successful login
            assert driver.getCurrentUrl().contains("Before you start") : "Login was successful";

            // Write test result to CSV file
            writeTestResult("Correct Credentials", "Passed");
            System.out.println("pass_correct_Credentials");

        } catch (Exception e) {
            System.err.println("Error occurred: on correct login credentials " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Correct Credentials", "Failed");
        }
    }

    // Test with incorrect credentials
    public static void testIncorrectCredentials() {
        try {
            // Navigate to the login page
            driver.get("https://aiworksquad.com/login");

            // Create an instance of the LoginPage class
            LoginPage loginPage = new LoginPage(driver);

            // Enter incorrect email and password
            loginPage.enterEmail("abc@gmail.com");
            loginPage.enterPassword("1234");
            loginPage.clickLogin();

            // Use WebDriverWait to wait for error message element visibility
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorMessageLocator()));

            // Add assertions to verify error message for incorrect credentials
            assert loginPage.getErrorMessage().equals("Invalid username or password") : "Error message is incorrect";

            // Write test result to CSV file
            writeTestResult("Incorrect Credentials", "Passed");
            System.out.println("pass_incorrect_credentials");
        } catch (Exception e) {
            System.err.println("Error occurred: on incorrect login credentials " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Incorrect Credentials", "Failed");
        }
    }
}
