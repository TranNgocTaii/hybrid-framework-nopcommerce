package actions.pageObjects.nopCommerce.user;

import actions.commons.BasePage;
import interfaces.pageUIs.nopCommerce.user.UserCustomerInfoPageUI;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCustomerInfoPageDisplayed() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
    }

}
