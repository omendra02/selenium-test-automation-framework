package Test;

import Pages.LeftHomePage;
import Pages.LoginPage;
import com.opencsv.CSVWriter;
import org.openqa.selenium.Dimension;
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

public class TestLeftHome {

    private static WebDriver driver;
    private static CSVWriter writer;
    private static final String CSV_FILE_PATH = "F:/javaselenium/TestResults/TestLeftHome.csv";

    public static void main(String[] args) {
        try {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            // Initialize WebDriver (ChromeDriver)
            driver = new ChromeDriver(options);
            Dimension dimension = new Dimension(1920, 1080);
            driver.manage().window().setSize(dimension);


            boolean fileExists = new File(CSV_FILE_PATH).exists();
            // Create a CSV file writer
            writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));

            if (!fileExists) {
                writer.writeNext(new String[]{"Date", "Time", "Test Name", "Status"});
            }

            // Test methods
            testProfileWindow();
            testDepartmentDropdown();
            testNewChat();
            testUpgradePlus();
            testUpdate();
            testTerms();
            testPrivacy();
            testContact();

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

    public static void testProfileWindow() {
        try {
            System.out.println("Testing the profile window");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click profile
            page.clickProfile();

            // Add assertions to verify successful
            assert LeftHomePage.Profileverified().equals("Profile") : "Error message is incorrect";
            System.out.println("Profile_exists_completed");

            // Write test result to CSV file
            writeTestResult("Profile Window", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testProfileWindow: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Profile Window", "Failed");
        }
    }

    public static void testDepartmentDropdown() {
        try {
            System.out.println("Testing the department dropdown");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click department dropdown
            page.ClickSelectdepartment();

            // Add assertions to verify successful
            assert LeftHomePage.Select_Department_Verified().equals("Sales") : "Message is incorrect";
            System.out.println("DropdownLocator");

            // Write test result to CSV file
            writeTestResult("Department Dropdown", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testDepartmentDropdown: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Department Dropdown", "Failed");
        }
    }

    public static void testNewChat() {
        try {
            System.out.println("Testing new chat");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click new chat
            page.ClickChat();

            // Add assertions to verify successful
            assert LeftHomePage.Select_chat_Verified().equals("Enter your query here...") : "Message is incorrect";
            System.out.println("newchatLocator");

            // Write test result to CSV file
            writeTestResult("New Chat", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testNewChat: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("New Chat", "Failed");
        }
    }

    public static void testUpgradePlus() {
        try {
            System.out.println("Testing Upgrade");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click upgrade
            page.ClickUpgrade();

            // Add assertions to verify successful
            assert LeftHomePage.UpgradeVerified().equals("Free") : "Message is incorrect";
            System.out.println("Upgrade");

            // Write test result to CSV file
            writeTestResult("Upgrade", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testUpgradeplus: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Upgrade", "Failed");
        }
    }

    public static void testUpdate() {
        try {
            System.out.println("Testing Update");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click updates
            page.ClickUpdates();

            // Add assertions to verify successful
            assert LeftHomePage.UpdateVerified().equals("FAQ") : "Message is incorrect";
            System.out.println("Update");

            // Write test result to CSV file
            writeTestResult("Update", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testUpdate: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Update", "Failed");
        }
    }

    public static void testTerms() {
        try {
            System.out.println("Testing Terms");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click terms
            page.ClickTerms();

            // Add assertions to verify successful
            assert LeftHomePage.TermsVerified().equals("Terms and Conditions") : "Message is incorrect";
            System.out.println("Terms");

            // Write test result to CSV file
            writeTestResult("Terms", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testTerms: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Terms", "Failed");
        }
    }

    public static void testPrivacy() {
        try {
            System.out.println("Testing Privacy");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click privacy
            page.Clickprivacy();

            // Add assertions to verify successful
            assert LeftHomePage.PrivacyVerified().equals("Privacy Policy for AIWorkSquad") : "Message is incorrect";
            System.out.println("Privacy");

            // Write test result to CSV file
            writeTestResult("Privacy", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testPrivacy: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Privacy", "Failed");
        }
    }

    public static void testContact() {
        try {
            System.out.println("Testing Contact");

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
            LeftHomePage page = new LeftHomePage(driver);

            // Click contact us
            page.ClickContactus();

            // Use WebDriverWait to wait for page load or specific element visibility
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(LeftHomePage.Contactus()));

            // Add assertions to verify successful
            assert LeftHomePage.ContactVerified().equals("Contact Us") : "Message is incorrect";
            System.out.println("ContactUs");

            // Write test result to CSV file
            writeTestResult("Contact", "Passed");
        } catch (Exception e) {
            System.err.println("An error occurred in testContact: " + e.getMessage());
            // Write test result to CSV file
            writeTestResult("Contact", "Failed");
        }
    }
}
