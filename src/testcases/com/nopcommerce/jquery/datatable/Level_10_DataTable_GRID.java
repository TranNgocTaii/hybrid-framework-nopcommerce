package testcases.com.nopcommerce.jquery.datatable;

import actions.commons.BaseTest;
import actions.pageObjects.jQuery.HomePageObject;
import actions.pageObjects.jQuery.PageGeneratorManager;
import actions.pageObjects.nopCommerce.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Level_10_DataTable_GRID extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    List<String> actualAllCountryValues;
    List<String> expectedAllCountryValues;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);
        homePage = PageGeneratorManager.getHomePage(driver);

    }

    public void Table_01_Paging() throws InterruptedException {

        homePage.openPagingByPageNumber("10");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isPageNumberActived("10"));

        homePage.openPagingByPageNumber("20");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isPageNumberActived("20"));

        homePage.openPagingByPageNumber("7");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isPageNumberActived("7"));

        homePage.openPagingByPageNumber("8");
        homePage.sleepInSecond(3);
        Assert.assertTrue(homePage.isPageNumberActived("8"));


    }

    public void Table_02_Enter_To_Header() {

        homePage.enterToHeaderTextBoxByLabel("Country", "Argentina");
        homePage.enterToHeaderTextBoxByLabel("Females", "338282");
        homePage.enterToHeaderTextBoxByLabel("Males", "349238");
        homePage.enterToHeaderTextBoxByLabel("Total", "687522");
        homePage.sleepInSecond(3);

        homePage.enterToHeaderTextBoxByLabel("Country", "Angola");
        homePage.enterToHeaderTextBoxByLabel("Females", "276880");
        homePage.enterToHeaderTextBoxByLabel("Males", "276472");
        homePage.enterToHeaderTextBoxByLabel("Total", "553353");
        homePage.sleepInSecond(3);

    }

    public void Table_03_Enter_To_Header() {
        actualAllCountryValues = homePage.getvalueEachRowAtAllPage();

        Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
    }

    @Test
    public void Table_04_Enter_To_Textbox_At_Any_Row() {
        homePage.clickToLoadButton();
        homePage.sleepInSecond(3);

/*        homePage.enterToTextboxAtRowNumberByColumnName("Company", "2", "Company");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "4", "Contact Person");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "6", "123123");
        homePage.sleepInSecond(2);

        homePage.selectDropDownByColumnNameAtRowNumber("Country","8","Hong Kong");
        homePage.sleepInSecond(2);

        homePage.selectDropDownByColumnNameAtRowNumber("Country","5","Japan");
        homePage.sleepInSecond(2);

        homePage.checkToChecboxByColumnNameAtRowNumber("NPO?", "3");
        homePage.checkToChecboxByColumnNameAtRowNumber("NPO?", "5");
        homePage.unCheckToChecboxByColumnNameAtRowNumber("NPO?", "1");
        homePage.unCheckToChecboxByColumnNameAtRowNumber("NPO?", "2");
        homePage.unCheckToChecboxByColumnNameAtRowNumber("NPO?", "4");*/

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Insert Row Above");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Move Up");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);



    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}

