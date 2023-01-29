package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject openRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        // return new RegisterPageObject(driver);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject openLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }


    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
    }

    public CustomerInfoPageObject openMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MYACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
