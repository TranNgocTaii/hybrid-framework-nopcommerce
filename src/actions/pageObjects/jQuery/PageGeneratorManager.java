package actions.pageObjects.jQuery;

import actions.pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import actions.pageObjects.nopCommerce.admin.AdminLoginPageObject;
import actions.pageObjects.nopCommerce.user.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
}
