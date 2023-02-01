package testcases.com.nopcommerce.user;

import actions.pageObjects.nopCommerce.user.UserHomePageObject;
import actions.pageObjects.nopCommerce.user.UserLoginPageObject;
import actions.pageObjects.nopCommerce.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object_02_Login {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    private String firstName, lastName, invalidPassword, validPassword, existingEmail, notFoundEmail, invalidEmail;


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
        invalidEmail = "afc@afc.com@.vn";
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
        existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
        validPassword = "123456";
        invalidPassword = "654321";


        System.out.println("Pre-Condition - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Pre-Condition - Step 02: Input to required field");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(existingEmail);
        registerPage.inputToPasswordTextbox(validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        System.out.println("Pre-Condition - Step 03: Click to Register Button");
        registerPage.clickToRegisterButton();

        System.out.println("Pre-Condition - Step 04: Verify success message displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        System.out.println("Pre-Condition - Step 04: Click to Continue Button");
        registerPage.clickToContinueButton();
    }

    @Test
    public void Login_01_Empty_Data() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(invalidEmail);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }

    @Test
    public void Login_03_Email_Not_Found() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(notFoundEmail);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

    }

    @Test
    public void Login_04_Existing_Email_Empty_Password() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_05_Existing_Email_Incorrect_Password() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox(invalidPassword);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_06_Valid_Email_Password() {
        homePage.openLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox(validPassword);

        loginPage.clickToLoginButton();

        homePage = new UserHomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    public int generateFakeNumber() {
        Random rad = new Random();
        return rad.nextInt(9999);
    }

    @AfterClass
    public void afterClass(){

    }
}

