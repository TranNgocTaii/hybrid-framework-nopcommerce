package testcases.com.nopcommerce.user;

import actions.commons.BaseTest;
import actions.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private MyProductReviewPageObject myProductReviewPage;
    private RewardPointPageObject rewardPointPage;

    private String firstName, lastName, validPassword, emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.driver = getBrowserDriver(browserName);

        driver.get("https://demo.nopcommerce.com/");

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
        validPassword = "123456";

    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.openRegisterLink();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToContinueButton();

    }

    @Test
    public void User_02_Login() {
        loginPage = homePage.openLoginLink();

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(validPassword);

        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_Customer_Info() {
        customerInfoPage = homePage.openMyAccountLink();
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

    }

    @Test
    public void User_04_Switch_Page() {
        // Customer Info -> Address
        addressPage = customerInfoPage.openAddressPage(driver);
        // Address -> My Product Review
        myProductReviewPage = addressPage.openMyProductReviewPage(driver);
        // My Product Review -> Reward Point
        rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
        // Reward Point -> Address
        addressPage = rewardPointPage.openAddressPage(driver);
        // Address -> Reward Point
        rewardPointPage = addressPage.openRewardPointPage(driver);
        // Reward Point -> My Product Review
        myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
        // My Product Review -> Address
        addressPage = myProductReviewPage.openAddressPage(driver);
        // Adress -> Customer info
        customerInfoPage = addressPage.openCustomerInfoPage(driver);


    }

    @Test
    public void User_05_Switch_User() {

    }



    @AfterClass
    public void afterClass(){

    }
}

