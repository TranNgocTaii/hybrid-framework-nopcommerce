package actions.pageObjects.nopCommerce.admin;

import actions.commons.BasePage;
import interfaces.pageUIs.nopCommerce.admin.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardHeaderDisplayed(){
        waitForElementVisible(driver, AdminLoginPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(driver, AdminLoginPageUI.DASHBOARD_HEADER);
    }
}
