/*
package testcases.com.nopcommerce.user;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Apply_BasePage_I {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String emailAddress;

    // Declare (Khai bao)
    BasePage basePage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();

        // Initial (Khoi tao)
        basePage = new BasePage();

        emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register_Emtpy_Data(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"),"Password is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");
    }

    @Test
    public void TC_02_Invalid_Email(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendKeysToElement(driver,"//input[@id='Email']","123@456#$%^");
        basePage.sendKeysToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Wrong email");

    }

    @Test
    public void TC_03_Register_Success(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");
    }

    @Test
    public void TC_04_Register_Existing_Email(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//form//li"),"The specified email already exists");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver,"//input[@id='Password']","123");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']","123");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendKeysToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendKeysToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendKeysToElement(driver,"//input[@id='Email']", emailAddress);
        basePage.sendKeysToElement(driver,"//input[@id='Password']","123456");
        basePage.sendKeysToElement(driver,"//input[@id='ConfirmPassword']","123");

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");

    }

    public int generateFakeNumber() {
        Random rad = new Random();
        return rad.nextInt(9999);
    }

    @AfterClass
    public void afterClass(){

    }
}

*/
