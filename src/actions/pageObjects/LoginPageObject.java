package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }


    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextbox(String invalidEmail) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
    }

    public String getErrorMessageUnsuccessful() {
        waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }
}
