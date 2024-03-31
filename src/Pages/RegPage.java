package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPage {
    private WebDriver driver1;

    String apiKey = "vWi26ZLcbt7N4smnG9dgsSqdKXrzC9wL";
    String serverId = "hskiiqeh";
    String serverDomain = "hskiiqeh.mailosaur.net";

    public String getRandomEmail() {
        return "user" + System.currentTimeMillis() + "@" + serverDomain;
    }

    // WebElements defined using FindBy annotation
    @FindBy(xpath = "//input[@name='email']")
    private WebElement EmailTextBox;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement Password;

    @FindBy(xpath = "//div[@class='btn btn-success']")
    private WebElement EmailOtp;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement RegButton;

    @FindBy(xpath = "//input[@type = 'email']")//gmail
    private WebElement entergmail;

    @FindBy(xpath = "//span[normalize-space()='Next']")//gmail next
    private WebElement Next;

    @FindBy(xpath = "//input[@name='Passwd']") //gmail pass
    private WebElement PassGmail;

    public By EmailExistsLocator = By.xpath("//div[contains(text(),'User already exists with this email.')]");

    public By OtpSendError = By.xpath("//div[contains(text(),'OTP send error')]");
    public By OtpValidator = By.xpath("//div[contains(text(),'OTP sent successfully')]");

    public By emailverifyed = By.xpath("//div[contains(text(),'Email verified successfully')]");
    public By Next1 = By.xpath("//*[@id='passwordNext']/div/button");

    //constructor
    public RegPage(WebDriver driver) {
        this.driver1 = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter email into the email text box
    public void enterEmail(CharSequence username) {
        EmailTextBox.clear(); // Clear any existing text
        EmailTextBox.sendKeys(username); // Enter the provided email
    }

    //enter username into text box
    public void enterUsername(CharSequence username) {
        usernameTextBox.clear(); // Clear any existing text
        usernameTextBox.sendKeys(username); // Enter the provided email
    }

    // Method to enter password into the password text box
    public void enterPassword(String password) {
        //password.clear(); // Clear any existing text
        // password.sendKeys(password); // Enter the provided password
    }

    // Method to click on the login button
    public void clickReg() {
        RegButton.click(); // Click on the login button
    }

    //Method to click otp button
    public void clickOtp() {
        EmailOtp.click(); // Click on the login button
    }

    public void clickNext() {
        Next.click(); // Click on the login button
    }


    // Method to get the text of the error message
    public String UserExists() {
        WebElement UserExistsElement = driver1.findElement(EmailExistsLocator); // Find the user message element
        return UserExistsElement.getText(); // Return the text of the error message
    }

    // Method to get the locator for the error message element
    public By UserExistsLocator() {
        return EmailExistsLocator; // Return the locator for the error message element
    }

    public By OtpSendErrors() {
        return OtpSendError; // Return the locator for the error message element
    }

    public String OtpError() {
        WebElement OtpErrorElement = driver1.findElement(OtpSendError); // Find the user message element
        return OtpErrorElement.getText(); // Return the text of the error message
    }

    public By Emailverifiedlocator() {
        return emailverifyed; // Return the locator for the error message element
    }

    public String EmailVerified() {
        WebElement EmailVerify = driver1.findElement(emailverifyed); // Find the user message element
        return EmailVerify.getText(); // Return the text of the error message
    }


}