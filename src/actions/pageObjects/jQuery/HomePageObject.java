package actions.pageObjects.jQuery;

import actions.commons.BasePage;
import interfaces.pageUIs.jQuery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject (WebDriver driver){
        this.driver = driver;
    }


    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver,HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
    }

    public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
        waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
        sendKeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
        pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
    }

    public List getvalueEachRowAtAllPage() {
        int totalPage = getElementSize(driver,HomePageUI.TOTAL_PAGINGATION);
        System.out.println("Total size" + totalPage);

        List<String> allRowValuesAllPage = new ArrayList<String>();

        for (int index = 1 ; index <= totalPage; index++){
            clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));

            List<WebElement> allRowEachPage = getListWebElement(driver,HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
            for(WebElement eachRow : allRowEachPage){
                allRowValuesAllPage.add(eachRow.getText());

            }
        }
        for (String value : allRowValuesAllPage){
            System.out.println(value);
        }
        return allRowValuesAllPage;
    }
}
