package javaTester.intellijTips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;

public class Topic_03_Getter_Setter {
    WebDriver driver;
    String address = new String("Ho Chi Minh");

    public void Login_01_Email_Empty() throws InterruptedException {
        driver = new FirefoxDriver();

    }

    public void Login_02_Email_Empty() throws InterruptedException {
        WebDriver driver = null;

        driver.get("");

        this.driver.getCurrentUrl();
    }

    public int getRandomNumber(){
        Random rad = new Random();
        return rad.nextInt(99999);
    }
}
