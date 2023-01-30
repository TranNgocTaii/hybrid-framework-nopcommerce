package actions.pageObjects.nopCommerce.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.nopCommerce.user.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;
    
    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }


    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextbox(String invalidEmail) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, invalidEmail);
    }

    public String getErrorMessageUnsuccessful() {
        waitForElementVisible(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePageObject loginAsUser(String emailAdress, String password){
        inputToEmailTextbox(emailAdress);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
