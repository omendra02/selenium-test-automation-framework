package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHome {

        private static WebDriver driver;

        public MainHome(WebDriver driver) {
            Pages.MainHome.driver = driver;
            PageFactory.initElements(driver, this);
        }

        // WebElements defined using FindBy annotation
        @FindBy(xpath = "//div[@class='border input-group']//input[@placeholder='Enter your query here...']")
        private static WebElement Chat;

         @FindBy(xpath = "//button[normalize-space()='New Chat']")
         private static WebElement NewChat;

    @FindBy(xpath = "(//span[@class='cursor-pointer border-0 custom-cursor input-group-text'])[1]")
        private static WebElement chatsend;

        public void clickchat() {
            Chat.click();
        }

         public void ClicknewChat() {
            NewChat.click();
    }
      public void clicksend() {
        chatsend.click();
       }


      public static void enterchat(CharSequence chat) {
        Chat.clear(); // Clear any existing text
        Chat.sendKeys(chat); // Enter the provided email
    }
        public static By ProfileExists = By.xpath("//a[normalize-space()='']");
        public static By selectdepartment1 = By.xpath("//button[@class='header-dropdown dropdown-toggle btn btn-secondary']");

        public static By Select_Department_dropdown = By.xpath("//button[normalize-space()='Sales']");
        public static By NewChatValidator = By.xpath("//input[contains(@class,'placeHolder_color form-control')]");

        public static By UpgradeValidator = By.xpath("//p[normalize-space()='Free']");
        public static By UpdateValidator = By.xpath("//h2[normalize-space()='FAQs']");

        public static By TermsconditionsValidator = By.xpath("//h2[normalize-space()='Terms and Conditions']");

        public static By PrivacyPolicyValidator = By.xpath("//h2[normalize-space()='Privacy Policy for AIWorkSquad']");

        public static By ContactValidator = By.xpath("//h1[normalize-space()='Contact Us']");

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
            WebElement chat = driver.findElement(UpgradeValidator);
            return chat.getText(); // Return the text
        }
        public static String UpdateVerified() {
            WebElement chat = driver.findElement(UpdateValidator);
            return chat.getText(); // Return the text
        }

        public static String TermsVerified() {
            WebElement chat = driver.findElement(TermsconditionsValidator);
            return chat.getText();
        }

        public static String PrivacyVerified() {
            WebElement chat = driver.findElement(PrivacyPolicyValidator);
            return chat.getText();
        }

        public static String ContactVerified() {
            WebElement chat = driver.findElement(ContactValidator);
            return chat.getText();
        }
}

