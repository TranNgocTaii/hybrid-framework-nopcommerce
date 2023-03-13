package actions.pageObjects.jQuery.dataTable;

import actions.commons.BasePage;
import interfaces.pageUIs.jQuery.dataTable.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
        int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;

        waitForElementVisible(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        sendKeysToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
    }

    public void selectDropDownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
        int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;

        waitForElementClickable(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber, String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,valueToSelect, rowNumber, String.valueOf(columnIndex));

    }

    public void clickToLoadButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_BUTTON);
    }

    public void checkToChecboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;

        waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex) );
    }

    public void unCheckToChecboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;

        waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        uncheckToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));

    }

    public void clickToIconByRowNumber(String rowNumber, String iconName) {
        waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
        clickToElement(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER,rowNumber,iconName);


    }

}
