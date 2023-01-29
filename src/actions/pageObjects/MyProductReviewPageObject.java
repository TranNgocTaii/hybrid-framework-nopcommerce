package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.MyProductReviewPageUI;
import org.openqa.selenium.WebDriver;

public class MyProductReviewPageObject extends BasePage {
    WebDriver driver;

    public MyProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }


}
