package Test;
import Pages.LoginPage;
import Config.TestConfig;
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
    private static WebDriver driver;
    private static CSVWriter writer;
    private static final String CSV_FILE_PATH = TestConfig.getTestResultsPath() + "/TestLogin.csv";

    public static void main(String[] args) {
        try {
            // Initialize WebDriver (ChromeDriver)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            boolean fileExists = new File(CSV_FILE_PATH).exists();
            writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));

            if (!fileExists) {
                writer.writeNext(new String[]{"Date", "Time", "Test Name", "Status"});
            }

            testCorrectCredentials();
            testIncorrectCredentials();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        writer.writeNext(new String[]{formattedDate.split(" ")[0], formattedDate.split(" ")[1], testName, status});
    }

    public static void testCorrectCredentials() {
        try {
            driver.get(TestConfig.getBaseUrl() + "/login");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterEmail(TestConfig.getValidEmail());
            loginPage.enterPassword(TestConfig.getValidPassword());
            loginPage.clickLogin();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("chat"));

            assert driver.getCurrentUrl().contains("Before you start") : "Login was successful";
            writeTestResult("Correct Credentials", "Passed");
            System.out.println("pass_correct_Credentials");

        } catch (Exception e) {
            System.err.println("Error occurred: on correct login credentials " + e.getMessage());
            writeTestResult("Correct Credentials", "Failed");
        }
    }

    public static void testIncorrectCredentials() {
        try {
            driver.get(TestConfig.getBaseUrl() + "/login");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterEmail(TestConfig.getInvalidEmail());
            loginPage.enterPassword(TestConfig.getInvalidPassword());
            loginPage.clickLogin();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorMessageLocator()));

            assert loginPage.getErrorMessage().equals("Invalid username or password") : "Error message is incorrect";
            writeTestResult("Incorrect Credentials", "Passed");
            System.out.println("pass_incorrect_credentials");
        } catch (Exception e) {
            System.err.println("Error occurred: on incorrect login credentials " + e.getMessage());
            writeTestResult("Incorrect Credentials", "Failed");
        }
    }
}
