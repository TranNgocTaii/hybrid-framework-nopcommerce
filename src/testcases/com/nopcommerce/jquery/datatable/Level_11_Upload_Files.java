package testcases.com.nopcommerce.jquery.datatable;

import actions.commons.BaseTest;
import actions.pageObjects.jQuery.uploadFiles.HomePageObject;
import actions.pageObjects.jQuery.uploadFiles.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Level_11_Upload_Files extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    String test = "test.jpeg";
    String test1 = "test1.jpeg";
    String test2 = "test2.jpeg";
    String[] multipleFileNames ={test, test1, test2 };


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);

        homePage = PageGeneratorManager.getHomePage(driver);
    }


    public void Upload_01_One_File_Per_Time() {
        homePage.uploadMultipleFiles(driver, test);

        Assert.assertTrue(homePage.isFileLoadedByName(test));

        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(test));

        Assert.assertTrue(homePage.isFileImageUpLoadedByName(test));




    }

    @Test
    public void Upload_02_Multiple_File_Per_Time() {
        homePage.uploadMultipleFiles(driver, multipleFileNames);

        Assert.assertTrue(homePage.isFileLoadedByName(test));
        Assert.assertTrue(homePage.isFileLoadedByName(test1));
        Assert.assertTrue(homePage.isFileLoadedByName(test2));


        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(test));
        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(test1));
        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(test2));



        Assert.assertTrue(homePage.isFileImageUpLoadedByName(test));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(test1));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(test2));



    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}

