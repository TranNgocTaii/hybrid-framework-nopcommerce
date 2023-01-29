package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.CustomerInfoPageUI;
import org.openqa.selenium.WebDriver;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCustomerInfoPageDisplayed() {
        waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
    }

}
