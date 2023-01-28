package testcases.com.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_04_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private String firstName, lastName, password, emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.driver = getBrowserDriver(browserName);

        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePageObject(driver);

        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void Register_01_Emtpy_Data(){
        System.out.println("Register_01 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        System.out.println("Register_01 - Step 02: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Register_01 - Step 03: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(),"First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(),"Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(),"Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),"Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),"Password is required.");

    }

//    @Test
    public void Register_02_Invalid_Email(){
        System.out.println("Register_02 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

//    @Test
    public void Register_03_Register_Success(){
        System.out.println("Register_03 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

//    @Test
    public void Register_04_Register_Existing_Email(){
        System.out.println("Register_04 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

//    @Test
    public void Register_05_Register_Password_Less_Than_6_Chars(){
        System.out.println("Register_05 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

//    @Test
    public void Register_06_Register_Invalid_Confirm_Password(){
        System.out.println("Register_06 - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

