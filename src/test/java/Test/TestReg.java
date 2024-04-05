package Test;

import Pages.RegPage;
import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
    private static WebDriver driver;
    private static CSVWriter writer;
    private static final String CSV_FILE_PATH = "F:/javaselenium/TestResults/TestReg.csv";

    public static void main(String[] args) {
        try {
            // Initialize WebDriver (ChromeDriver)

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

            driver = new ChromeDriver(options);

            boolean fileExists = new File(CSV_FILE_PATH).exists();
            // Create a CSV file writer
            writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));

            if (!fileExists) {
                writer.writeNext(new String[]{"Date", "Time", "Test Name", "Status"});
            }
            // Test methods
            testEmailAlreadyExists();
            testInvalidEmail();
            //testOtp();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
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

    public static void testEmailAlreadyExists() {
        try {
            // Test logic for email already exists
            // Navigating to the Registration page...
            System.out.println("Navigating to the Registration page...");
            driver.get("https://aiworksquad.com/auth-signup-cover");

            // Create an instance of the RegPage class
            RegPage regPage = new RegPage(driver);

            // Enter existing email
            System.out.println("Entering existing email");
            regPage.enterEmail("omendra108@gmail.com");
            regPage.clickOtp();

            // Wait for page load or specific element visibility
            System.out.println("Verify the existing user");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(regPage.UserExistsLocator()));

            // Verify error message
            assert regPage.UserExists().equals("User already exists with this email.") : "Error message is incorrect";
            System.out.println("email_already_exists_completed");

            // Write test result to CSV file
            writeTestResult("Email Already Exists", "Passed");
        } catch (Exception e) {
            System.out.println("Error occurred: Email Already Exists " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Email Already Exists", "Failed");
            e.printStackTrace();
        }
    }

    public static void testInvalidEmail() {
        try {
            // Test logic for invalid email
            // Navigating to the Registration page...
            System.out.println("Navigating to the Registration page...");
            driver.get("https://aiworksquad.com/auth-signup-cover");

            // Create an instance of the RegPage class
            RegPage regPage = new RegPage(driver);

            // Enter invalid email
            System.out.println("Entering invalid email");
            regPage.enterEmail("omendragmail.com");
            regPage.clickOtp();

            // Wait for error message element visibility
            System.out.println("Verify the error message for invalid email");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(regPage.OtpSendErrors()));

            // Verify error message
            assert regPage.OtpError().equals("OTP send error") : "Error message is incorrect";
            System.out.println("correct_error_message");

            // Write test result to CSV file
            writeTestResult("Invalid Email", "Passed");
        } catch (Exception e) {
            System.out.println("Error occurred: Invalid Email " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Invalid Email", "Failed");
            e.printStackTrace();
        }
    }

    public static void testOtp() {
        try {
            // Test logic for OTP
            String apiKey = "vWi26ZLcbt7N4smnG9dgsSqdKXrzC9wL";
            String serverId = "hskiiqeh";
            String serverDomain = "hskiiqeh.mailosaur.net";
            String sentFrom = "noreply@aiworksquad.com";

            // Navigating to the Registration page...
            System.out.println("Navigating to the Registration page...");
            driver.get("https://aiworksquad.com/auth-signup-cover");

            // Create an instance of the RegPage class
            RegPage regPage = new RegPage(driver);

            // Enter new email and generate OTP
            System.out.println("Entering new email and generating OTP");
            String emailid = regPage.getRandomEmail();
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailid);
            regPage.clickOtp();

            // Retrieve OTP from email
            //MailosaurClient mailosaur = new MailosaurClient(apiKey);
            MessageSearchParams params = new MessageSearchParams();
            params.withServer(serverId);

            SearchCriteria criteria = new SearchCriteria();
            criteria.withSentTo(emailid);
            criteria.withSentFrom(sentFrom);

            Message message = mailosaur.messages().get(params, criteria);
            String body = message.html().body();

            // Extract OTP from email body
            Pattern pattern = Pattern.compile("<h1>(\\d+)</h1>");
            Matcher matcher = pattern.matcher(body);
            matcher.find();
            String otp = matcher.group(1);

            // Enter OTP and verify email
            System.out.println("Entering OTP and verifying email");
            driver.findElement(By.xpath("//input[@name='otp']")).sendKeys(otp);
            // Click verify button or perform necessary actions
            // Wait for email verification success message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(regPage.Emailverifiedlocator()));

            // Verify email verification success message
            assert regPage.EmailVerified().equals("Email verified successfully") : "Error message is incorrect";
            System.out.println("email_verification_completed");

            // Write test result to CSV file
            writeTestResult("OTP", "Passed");
        } catch (Exception e) {
            System.out.println("Error occurred: TestOTP " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("OTP", "Failed");
            e.printStackTrace();
        }
    }
}
