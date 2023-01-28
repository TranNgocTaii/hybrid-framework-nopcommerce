package actions.pageFactory;

import actions.commons.BasePageFactory;
import interfaces.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Page UI

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
    private WebElement unsuccessErrorMessage;

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public void inputToEmailTextbox(String invalidEmail) {
        waitForElementVisible(driver, emailTextbox);
        sendKeysToElement(driver, emailTextbox, invalidEmail);
    }

    public String getErrorMessageUnsuccessful() {
        waitForElementVisible(driver, unsuccessErrorMessage);
        return getElementText(driver, unsuccessErrorMessage);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeysToElement(driver, passwordTextbox, password);
    }
}
