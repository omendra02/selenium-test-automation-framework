package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.jayway.jsonpath.JsonPath;
//import net.minidev.json.JSONObject;
import java.io.File;

public class LoginPage {
    private WebDriver driver;

    // WebElements defined using FindBy annotation
   @FindBy(xpath = "//input[contains(@placeholder,'Enter your email here')]")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@placeholder='Enter your password here']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement loginButton;

    // Locator for the error message element
    public By errorMessageLocator = By.xpath("//div[@role='alert']/div");

    // Constructor to initialize WebDriver and PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /*public WebElement getlocator(String locator){

        File jsonFile = new File(System.getProperty("F://AiWorkSquad//src//Resource//object.json"));
        String temploc = ((String) JsonPath.read(jsonFile,locator));
        return driver.findElement(By.xpath(temploc));
    }
    // Method to enter email into the email text box
    public void enterEmail(CharSequence email) {
        WebElement ele = getlocator("loginPage");
        ele.sendKeys(email);
        //usernameTextBox.clear(); // Clear any existing text
        //usernameTextBox.sendKeys(email); // Enter the provided email
    }*/

    public void enterEmail(CharSequence email) {
        usernameTextBox.clear(); // Clear any existing text
        usernameTextBox.sendKeys(email); // Enter the provided email
    }
    // Method to enter password into the password text box
    public void enterPassword(String password) {
        passwordTextBox.clear(); // Clear any existing text
        passwordTextBox.sendKeys(password); // Enter the provided password
    }

    // Method to click on the login button
    public void clickLogin() {
        loginButton.click(); // Click on the login button
    }

    // Method to get the text of the error message
    public String getErrorMessage() {
        WebElement errorMessageElement = driver.findElement(errorMessageLocator); // Find the error message element
        return errorMessageElement.getText(); // Return the text of the error message
    }

    // Method to get the locator for the error message element
    public By getErrorMessageLocator() {
        return errorMessageLocator; // Return the locator for the error message element
    }
}
