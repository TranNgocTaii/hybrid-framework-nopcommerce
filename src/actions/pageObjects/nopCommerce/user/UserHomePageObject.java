package actions.pageObjects.nopCommerce.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.nopCommerce.user.UserHomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject openRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        // return new RegisterPageObject(driver);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPageObject openLoginLink() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);
    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
    }

    public UserCustomerInfoPageObject openMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
        return PageGeneratorManager.getUserMyAccountPage(driver);
    }
}
