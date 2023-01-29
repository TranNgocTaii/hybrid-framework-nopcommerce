package testcases.com.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.LoginPageObject;
import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    private String firstName, lastName, invalidPassword, validPassword, existingEmail, notFoundEmail, invalidEmail;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.driver = getBrowserDriver(browserName);

        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePageObject(driver);

        firstName = "Automation";
        lastName = "FC";
        invalidEmail = "afc@afc.com@.vn";
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
        existingEmail = "afc" + generateFakeNumber() + "@gmail.com";
        validPassword = "123456";
        invalidPassword = "654321";


        System.out.println("Pre-Condition - Step 01: Click to Register link");
        homePage.openRegisterLink();

        registerPage = new RegisterPageObject(driver);

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

        loginPage = new LoginPageObject(driver);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email() {
        homePage.openLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(invalidEmail);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }

    @Test
    public void Login_03_Email_Not_Found() {
        homePage.openLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(notFoundEmail);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

    }

    @Test
    public void Login_04_Existing_Email_Empty_Password() {
        homePage.openLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_05_Existing_Email_Incorrect_Password() {
        homePage.openLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox(invalidPassword);

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_06_Valid_Email_Password() {
        homePage.openLoginLink();

        loginPage = new LoginPageObject(driver);

        loginPage.inputToEmailTextbox(existingEmail);

        loginPage.inputToPasswordTextbox(validPassword);

        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }



    @AfterClass
    public void afterClass(){

    }
}

