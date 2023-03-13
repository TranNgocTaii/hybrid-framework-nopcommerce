package actions.pageObjects.jQuery.uploadFiles;

import actions.commons.BasePage;
import interfaces.pageUIs.jQuery.uploadFiles.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject (WebDriver driver){
        this.driver = driver;
    }


    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
    }

    public void clickToStartButton() {
        List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);

        for (WebElement startButton : startButtons){
            startButton.click();
            sleepInSecond(2);
        }
    }

    public boolean isFileLinkUpLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
    }

    public boolean isFileImageUpLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
        return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
    }
}
