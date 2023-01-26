package javaTester.javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic_12_String {

    public static void main (String[] args){
/*        System.setProperty("webdriver.chrome.driver", "./browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        String schoolName = "Automation Testing Advanced";
        String schoolAddress = "Ho Chi Minh city";
        String courseName = "automation TESTING advanced";

        // Do dai
        System.out.println("Do dai = " + schoolName.length());

        // Lay ra 1 ki tu
        System.out.println("Lay ra 1 ki tu: " + schoolName.charAt(0));

        // Noi 2 chuoi
        System.out.println("Noi 2 chuoi: " + schoolName.concat(schoolAddress));
        System.out.println("Noi 2 chuoi: " + schoolName + schoolAddress);

        // So sanh tuyet doi
        System.out.println("Kiem tra 2 chuoi co bang nhau tuyet doi: " + schoolName.equals(schoolAddress));
        System.out.println("Kiem tra 2 chuoi co bang nhau tuyet doi: " + schoolName.equals("Automation Testing Advanced"));

        // Multi browser
        System.out.println("Kiem tra 2 chuoi co bang nhau tuong doi: " + schoolName.equalsIgnoreCase(courseName));

        // startWith / endsWith / contains
        System.out.println("Co bat dau bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("A"));
        System.out.println("Co bat dau bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("Automation"));
        System.out.println("Co bat dau bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("T"));

        System.out.println("Co chua 1 ki tu/chuoi ki tu = " + schoolName.startsWith("Automation"));
        System.out.println("Co chua 1 ki tu/chuoi ki tu = " + schoolName.startsWith("T"));
        System.out.println("Co chua 1 ki tu/chuoi ki tu = " + schoolName.startsWith("Testing"));
        System.out.println("Co chua 1 ki tu/chuoi ki tu = " + schoolName.startsWith("World"));

        System.out.println("Co ket thuc bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("D"));
        System.out.println("Co ket thuc bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("Testing"));
        System.out.println("Co ket thuc bang 1 ki tu/chuoi ki tu = " + schoolName.startsWith("Automation"));

        System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf("utomation"));
        System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf("A"));
        System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf("Testing"));

        // Tach chuoi
        System.out.println("Tach 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.substring(11));
        System.out.println("Tach 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.substring(11, 15));

        // Split: Tach chuoi thanh 1 mang dua vao ki tu / chuoi ki tu
        // Alert
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" ");

        System.out.println(results[1]);

        // Replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$","");
        System.out.println(productPrice);

        // Sap xep no : Sort data (Asc/ Desc)
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

        String osName = System.getProperty("os.name");
        System.out.println(osName);
        // Window 10
        // Handle multiple OS: Mac / Windows ( Actions - keys - Ctrl / Command)
        if (osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        } else {
            Keys key  = Keys.COMMAND;
        }

        // Multiple browser : toUpperCase
        // firefox = FIREFOX (Enum)

        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);
        // ChromeDriver: chrome on MAC (4c4ae66b34e159be23ed0d874896da19)
        // Close browser / driver
        if (driverInstanceName.contains("internetexplorer")){
            // Sleep cung them 5s sau moi su kien chuyen page
        }*/

        String helloWorld = "\n \t Hello World!       ";
        System.out.println(helloWorld.trim());

        helloWorld = "  ";
        System.out.println("Empty: " + helloWorld.isEmpty());
        System.out.println("Blank: " + helloWorld.isBlank());

        // Dynamic locator
        // Dai dien cho 1 chuoi: %s
        // %b %t %d
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click to login button = " + dynamicButtonXpath.format(dynamicButtonXpath,"login"));
        System.out.println("Click to search button = " + dynamicButtonXpath.format(dynamicButtonXpath,"search"));
        System.out.println("Click to register button = " + dynamicButtonXpath.format(dynamicButtonXpath,"register"));



    }


}
