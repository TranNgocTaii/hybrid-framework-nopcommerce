package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
    // Primitive type / value type: Nguyen thuy
    byte bNumber;
    short sNumber;
    int iNumber;
    long lNumber;
    float fNumber;
    double dNumber;
    char cChar;
    boolean bStatus;

    // Reference type : Tham chieu

    // String
    String address = "Ho Chi Minh";

    // Array
    String[] studentAddress = {address, "Ha Noi", "Da Nang"};
    Integer[] studentNumber = {15, 20, 50};

    // Class
    Topic_02_Data_Type topic;

    // Interface
    WebDriver driver;

    // Object
    Object aObject;

    // Collection
    // List / Set / Queue / Map
    List<WebElement> homePageLink = driver.findElements(By.xpath("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productName = new ArrayList<String>();

    public void clickToElement(){
        address.trim();

        studentAddress.clone();

        driver.getCurrentUrl();

        aObject.toString();

        homePageLink.size();

        allWindows.clear();

        Topic_02_Data_Type topic = new Topic_02_Data_Type();

        topic.address = "Ha Noi";

    }

    public static void main (String[] args){


    }
}
