package testcases.com.nopcommerce.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.nopCommerce.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_09_Dynamic_Locator extends BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressPageObject addressPage;
    private UserMyProductReviewPageObject myProductReviewPage;
    private UserRewardPointPageObject rewardPointPage;

    private String firstName, lastName, validPassword, emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.driver = getBrowserDriver(browserName);

        driver.get("https://demo.nopcommerce.com/");

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
        validPassword = "123456";

    }

    @Test
    public void User_01_Register_Login() {
        registerPage = homePage.openRegisterLink();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

        registerPage.clickToContinueButton();

        loginPage = homePage.openLoginLink();

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(validPassword);

        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        customerInfoPage = homePage.openMyAccountLink();
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

    }

    @Test
    public void User_02_Switch_Page() {
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

    }

    @Test
    public void User_03_Dynamic_Page_01() {
        rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver,"Reward points");

        addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver,"Addresses");

        rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver,"Reward points");

        myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");

        customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
    }

    @Test
    public void User_03_Dynamic_Page_02() {
        customerInfoPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
        myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

        myProductReviewPage.openPagesAtMyAccountByPageName(driver,"Reward points");
        rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

        rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
        addressPage = PageGeneratorManager.getUserAddressPage(driver);

        addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
        rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);





    }


        @Test
    public void User_05_Switch_User() {

    }



    @AfterClass
    public void afterClass(){

    }
}

