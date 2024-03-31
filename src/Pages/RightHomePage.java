package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightHomePage {


    private static WebDriver driver;

        public RightHomePage(WebDriver driver) {
            Pages.RightHomePage.driver = driver;
            PageFactory.initElements(driver, this);
        }

        // WebElements defined using FindBy annotation
        @FindBy(xpath = "//a[normalize-space()='Related Questions']")
        private WebElement RelatedQuestions;
        @FindBy(xpath = "//a[normalize-space()='Prompts']")
        private WebElement Prompts;

        @FindBy(xpath = "//a[normalize-space()='Image Generator']")
        private WebElement imageGenerator;

        @FindBy(xpath = "//button[normalize-space()='Generate']")
        private WebElement Generate;

        @FindBy(xpath = "//input[@class='form-control form-control']")
        private static WebElement img_Generator;

        //public static WebElement image = img_Generator.findElement(By.xpath("(//img)[2]"));
        @FindBy(xpath = "//div[@class='tab-pane active']//div[1]")
        private WebElement SalesOperation;

        @FindBy(xpath = "(//*[name()='svg'][@class='fs-2 mr-4 cursor-pointer'])[1]")
        private WebElement SalesOperationBack;

        @FindBy(xpath = "//h5[normalize-space()='Sales Training']")
        private WebElement SalesTraining;
        @FindBy(xpath = "(//*[name()='svg'][@class='fs-2 mr-4 cursor-pointer'])[1]")
        private WebElement SalesTrainingback;


        @FindBy(xpath = "//h5[normalize-space()='Sales Technology']")
        private WebElement SalesTechnology;

        //after click sales Operations and Optimization
        @FindBy(xpath = "//div[normalize-space()='Sales Planning and Forecasting']")
        private WebElement planforcast;

        @FindBy(xpath = "//div[normalize-space()='Sales Process Optimization']")
        private WebElement salesProcess;

        @FindBy(xpath = "//div[normalize-space()='Sales Metrics and Performance Analysis']")
        private WebElement SalesPerformance;

        @FindBy(xpath = "//div[normalize-space()='Sales Compensation and Incentives']")
        private WebElement SalesCompensation;
        @FindBy(xpath = "//div[normalize-space()='Sales Territory Management']")
        private WebElement SalesTerritory;

        //After click Sales Training
        @FindBy(xpath = "//div[normalize-space()='Sales Training and Onboarding']")
        private WebElement Salesonboarding;

        @FindBy(xpath = "//div[normalize-space()='Sales Coaching and Management']")
        private WebElement SalesCoaching;

        @FindBy(xpath = "//div[normalize-space()='Sales Enablement']")
        private WebElement SalesEnablement;

        //after click sales technology
        @FindBy(xpath = "//div[normalize-space()='CRM Implementation and Management']")
        private WebElement crm;

        @FindBy(xpath = "//div[normalize-space()='Sales Technology and Tools']")
        private WebElement SalesTechTools;




        public static By salesplan = By.xpath("//div[normalize-space()='Sales Planning and Forecasting']");


        public static By  salesTrain = By.xpath("//div[normalize-space()='Sales Training and Onboarding']");

        public static By salesTech = By.xpath("//div[normalize-space()='CRM Implementation and Management']");

        public static By SalesOperations = By.xpath("//h5[normalize-space()='Sales Operations and Optimization']");


        public static By salesplanLocator() {
            return salesplan;
        }

        public static By salesTrainLocator() {
            return salesTrain;
        }

        public static By salesTechLocator() {
            return salesTech;
        }

        public static By getSalesOperations(){
            return SalesOperations;
        }


        public void ClickPrompt(){
            Prompts.click();
        }

        public void ClickRelated(){
            RelatedQuestions.click();
        }

        public void ClickImageGenerator(){
            imageGenerator.click();
        }

        public void ClickSalesOperation(){
            SalesOperation.click();
        }

        public void ClickSalesOperationback(){
            SalesOperationBack.click();
        }


        public void ClickSalesTraining(){
            SalesTraining.click();
        }

        public void ClickSalesTrainingback(){
        SalesTrainingback.click();
        }

        public void ClickSalesTechnology(){
            SalesTechnology.click();
        }

        public static void enterimage(CharSequence img_genration) {
            img_Generator.clear(); // Clear any existing text
            img_Generator.sendKeys(img_genration); // Enter the provided text
     }


        public static String SalesOperationverified() {
            WebElement saleOperation = driver.findElement(salesplan); // Find the message element
            return saleOperation.getText(); // Return the text
        }

        public static String SalesTrainingVerified() {
            WebElement SalesTrain = driver.findElement(salesTrain);
            return SalesTrain.getText(); // Return the text
        }

        public static String SalesTechVerified() {
            WebElement Tech = driver.findElement(salesTech);
            return Tech.getText(); // Return the text
        }
        public static String PromptVerified() {
            WebElement SalesOperation = driver.findElement(SalesOperations);
            return SalesOperation.getText(); // Return the text
        }




}

