package testcases.com.nopcommerce.user;

import actions.pageObjects.nopCommerce.user.UserHomePageObject;
import actions.pageObjects.nopCommerce.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object_01_Register {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    private String firstName, lastName, password, emailAddress;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        homePage = new UserHomePageObject(driver);

        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void Register_01_Emtpy_Data(){
        System.out.println("Register_01 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_01 - Step 02: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_01 - Step 03: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(),"First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(),"Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(),"Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),"Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email(){
        System.out.println("Register_02 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_02 - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox("123@456#$%^");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register_02 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_02 - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(),"Wrong email");
    }

    @Test
    public void Register_03_Register_Success(){
        System.out.println("Register_03 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_03 - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register_03 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_03 - Step 04: Verify success message displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
    }

    @Test
    public void Register_04_Register_Existing_Email(){
        System.out.println("Register_04 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_04 - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register_04 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_04 - Step 04: Verify error existing email message displayed");
        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
    }

    @Test
    public void Register_05_Register_Password_Less_Than_6_Chars(){
        System.out.println("Register_05 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_05 - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox("123");
        registerPage.inputToConfirmPasswordTextbox("123");

        System.out.println("Register_05 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_05 - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),"Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Register_Invalid_Confirm_Password(){
        System.out.println("Register_06 - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register_06 - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox("654321");

        System.out.println("Register_06 - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_06 - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),"The password and confirmation password do not match.");
    }

    public int generateFakeNumber() {
        Random rad = new Random();
        return rad.nextInt(9999);
    }

    @AfterClass
    public void afterClass(){

    }
}

