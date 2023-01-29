package actions.pageObjects;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import interfaces.pageUIs.RewardPointPageUI;
import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends BasePage {
    WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
