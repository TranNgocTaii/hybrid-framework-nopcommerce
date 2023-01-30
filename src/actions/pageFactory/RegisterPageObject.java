package actions.pageFactory;

import actions.commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMessage;

    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMessage;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(id = "Password-error")
    private WebElement passwordErrorMessage;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//form//li")
    private WebElement existingEmailErrorMessage;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getErrorMessageAtFirstNameTextBox() {
        waitForElementVisible(driver, firstNameErrorMessage);
        return getElementText(driver, firstNameErrorMessage);
    }

    public String getErrorMessageAtLastNameTextBox() {
        waitForElementVisible(driver, lastNameErrorMessage);
        return getElementText(driver, lastNameErrorMessage);
    }

    public String getErrorMessageAtEmailTextBox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public String getErrorMessageAtPasswordTextBox() {
        waitForElementVisible(driver, passwordErrorMessage);
        return getElementText(driver, passwordErrorMessage);
    }

    public String getErrorMessageAtConfirmPasswordTextBox() {
        waitForElementVisible(driver, confirmPasswordErrorMessage);
        return getElementText(driver, confirmPasswordErrorMessage);
    }

    public void inputToFirstNameTextbox(String firstNameValue) {
        waitForElementVisible(driver, firstNameTextbox);
        sendKeysToElement(driver, firstNameTextbox, firstNameValue);
    }

    public void inputToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver, lastNameTextbox);
        sendKeysToElement(driver, lastNameTextbox, lastNameValue);
    }

    public void inputToEmailTextbox(String emailValue) {
        waitForElementVisible(driver, emailTextbox);
        sendKeysToElement(driver, emailTextbox,emailValue);
    }

    public void inputToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeysToElement(driver, passwordTextbox,passwordValue);
    }

    public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendKeysToElement(driver, confirmPasswordTextbox,confirmPasswordValue);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerSuccessMessage);
        return getElementText(driver, registerSuccessMessage);
    }

    public String getErrorExistingEmailMessage() {
        waitForElementVisible(driver, existingEmailErrorMessage);
        return getElementText(driver, existingEmailErrorMessage);
    }

    public void clickToContinueButton() {
        waitForElementClickable(driver, continueButton);
        clickToElement(driver, continueButton);
    }


}
