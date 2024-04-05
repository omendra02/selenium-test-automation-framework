package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftHomePage {


    private static WebDriver driver;

    public LeftHomePage(WebDriver driver) {
        LeftHomePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements defined using FindBy annotation
    @FindBy(xpath = "//h3[normalize-space()='Before you start']")
    private WebElement BeforeyouStart;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement Confirm;

    @FindBy(xpath = "textarea[placeholder=\"Hi I'm Joe. Owner of an event management company in Delhi, India. Name of my company is Happen Events Pvt Ltd. We are specialized in conducting corporate and business events.\"]")
    private WebElement Starttextarea;

    @FindBy(xpath = "//button[normalize-space()='New Chat']")
    private WebElement NewChat;

    @FindBy(xpath = "//button[@class='header-dropdown dropdown-toggle btn btn-secondary']")
    private WebElement selectdepartment;

    @FindBy(xpath = "//button[@class ='btn']")
    private WebElement profileicon;

    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//a[1]")
    private WebElement Upgaradeplus;

    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//a[2]")
    private WebElement Updates;

    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//a[3]")
    private WebElement Termsconditions;

    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//a[4]")
    private WebElement Privacypolicy;
    @FindBy(xpath = "//body//div[@id='root']//div[@class='container']//div//div//a[5]")
    private WebElement Contactus;


    public static By ProfileExists = By.xpath("//a[normalize-space()='']");
    public static By selectdepartment1 = By.xpath("//button[@class='header-dropdown dropdown-toggle btn btn-secondary']");

    public static By Select_Department_dropdown = By.xpath("//button[normalize-space()='Sales']");
    public static By NewChatValidator = By.xpath("//input[contains(@class,'placeHolder_color form-control')]");

    public static By UpgradeValidator = By.xpath("//p[normalize-space()='Free']");
    public static By UpdateValidator = By.xpath("//h2[normalize-space()='FAQs']");

    public static By TermsconditionsValidator = By.xpath("//h2[normalize-space()='Terms and Conditions']");

    public static By PrivacyPolicyValidator = By.xpath("//h2[normalize-space()='Privacy Policy for AIWorkSquad']");

    public static By ContactValidator = By.xpath("//h1[normalize-space()='Contact Us']");

    public void clickProfile() {
        profileicon.click(); // Click on the profile button
    }

    public void clickConfirm() {
        Confirm.click();
    }

    public void ClickSelectdepartment() {
        selectdepartment.click();
    }

    public void ClickChat() {
        NewChat.click();
    }

    public void ClickUpgrade(){
        Upgaradeplus.click();
    }
    public void ClickUpdates(){
        Updates.click();
    }

    public void ClickTerms(){
        Termsconditions.click();
    }
    public void Clickprivacy(){
        Privacypolicy.click();
    }

    public void ClickContactus(){
        Contactus.click();
    }

    public static By ProfileExistsLocator() {
        return ProfileExists;
    }

    public static By Select_Department_DropdownLocator() {
        return selectdepartment1;
    }

    public static By NewChatLocator() {
        return NewChatValidator;
    }

    public static By UpgradeLocator(){
        return UpgradeValidator;
    }

    public static By UpdateLocator(){
        return UpdateValidator;
    }

    public static By TermsLocator(){
        return TermsconditionsValidator;
    }

    public static By PrivacyPolicyLocator(){
        return PrivacyPolicyValidator;
    }

    public static By Contactus(){
        return ContactValidator;
    }
    public static String Profileverified() {
        WebElement Profile = driver.findElement(ProfileExists); // Find the message element
        return Profile.getText(); // Return the text
    }

    public static String Select_Department_Verified() {
        WebElement Department = driver.findElement(Select_Department_dropdown);
        return Department.getText(); // Return the text
    }

    public static String Select_chat_Verified() {
        WebElement chat = driver.findElement(NewChatValidator);
        return chat.getText(); // Return the text
    }
    public static String UpgradeVerified() {
        WebElement upgrade = driver.findElement(UpgradeValidator);
        return upgrade.getText(); // Return the text
    }
    public static String UpdateVerified() {
        WebElement update = driver.findElement(UpdateValidator);
        return update.getText(); // Return the text
    }

    public static String TermsVerified() {
        WebElement terms = driver.findElement(TermsconditionsValidator);
        return terms.getText();
    }

    public static String PrivacyVerified() {
        WebElement privacy = driver.findElement(PrivacyPolicyValidator);
        return privacy.getText();
    }

    public static String ContactVerified() {
        WebElement contact = driver.findElement(ContactValidator);
        return contact.getText();
    }
}