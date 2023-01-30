package testcases.com.nopcommerce.user;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import actions.pageObjects.nopCommerce.admin.AdminLoginPageObject;
import actions.pageObjects.nopCommerce.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_08_Switch_Role extends BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPageObject userCustomerInfoPage;
    private UserAddressPageObject userAddressPage;
    private UserMyProductReviewPageObject userMyProductReviewPage;
    private UserRewardPointPageObject userRewardPointPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;

    private String firstName, lastName, userPassword, userEmailAddress, adminPassword, adminEmailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        this.driver = getBrowserDriver(browserName);

        driver.get(GlobalConstants.PORTAL_PAGE_URL);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        userEmailAddress = "automationfc1611@gmail.com.vn";
        userPassword = "123456";
        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";

    }

    @Test
    public void Role_01_User_To_Admin() {
        userLoginPage = userHomePage.openLoginLink();

        userLoginPage.loginAsUser(userEmailAddress, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userCustomerInfoPage = userHomePage.openMyAccountLink();

        userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);

        userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

        adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
    }

    @Test
    public void Role_02_Admin_To_User() {
        adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userLoginPage = userHomePage.openLoginLink();



    }


    @AfterClass
    public void afterClass(){

    }
}

