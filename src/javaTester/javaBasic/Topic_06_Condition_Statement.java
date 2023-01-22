package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_06_Condition_Statement {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public void TC_01_If(){

    }

    public void TC_02_If_Else(){
        // Co toi 2 dieu kien: neu nhu dung thi vao if - sai thi vao else

        // Neu driver start vs browser nhu Chrome / Firefox / Edge / Safari thi dung ham click
        // thong thuong (builtin) cua Selenium WebElement

        // Neu driver la IE thi dung ham click cua JavascriptExecutor



        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println(driver.toString());

        System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        driver = new FirefoxDriver();
        System.out.println(driver.toString());

        if(driver.toString().contains("firefox")){
            System.out.println("Click by Javascript Executor");
        } else {
            System.out.println("Click by Selenium WebElement");
        }
    }

    @Parameters("browser")
    public void TC_03_If_Else_If_Else(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
            driver = new EdgeDriver();
        } else { // safari / opera / coc coc
            throw new RuntimeException("Please input correct the browser name");
        }

    System.out.println(browserName);
    System.out.println(driver.toString());

    }

    public void TC_04_If_Else_If_Else(){
        // Page Object
        // Dynamic Page
        String pageName = "Login";

        if (pageName.equals("Login")){
            // LoginPage loginPage = new LoginPage();
            // return loginPage;
        } else if (pageName.equals("Register")){
            // RegisterPage registerPage = new RegisterPage();
            // return registerPage;
        } else if (pageName.equals("New Customer")){
            // CustomerPage customerPage = new CustomerPage;
            // return customerPage;
        } else {
            // HomePage homePage = new HomePage
            // return homePage;
        }

        // if-else
        int age = 20;
        String access = (age < 18) ? "You can not access" : "Welcome to our system!";

        if (age<18){
            System.out.println("You can not access");
        } else {
            System.out.println("Welcome to our system!");

        }




    }

   /* public static void main (String[] args){
        boolean status = 5>3;
        System.out.println(status);

        // Ham if se nhan 1 dieu kien dung
        // Kiem tra duy nhat 1 dieu kien
        // Neu dieu kien dung thi se action trong phan than
        if (status) {
            // Dung thi vao phan than
            // Sai thi bo qua
            System.out.println(true);
        }

        // Gan(assign)
        int studentNumber = 10;

        // So sanh
        status = (studentNumber == 10);

        WebDriver driver = new ChromeDriver();

        // Element luon luon co trong DOM du popup hien thi hay khong
        WebElement salePopup = driver.findElement(By.xpath(""));
        if(salePopup.isDisplayed()){

        }

        // Element khong co trong DOM khi popup khong hien thi
        List<WebElement> salePopups = driver.findElements(By.xpath(""));

        // Check element khong hien thi
        if(salePopups.size()>0 && salePopups.get(0).isDisplayed()){

        }

        //Uncheck to checkbox

        WebElement languageCheckbox = driver.findElement(By.xpath(""));

        if(languageCheckbox.isSelected()){
            languageCheckbox.click();
        }

        //Check to checkbox
        if(!languageCheckbox.isSelected()){
            languageCheckbox.click();
        }

    }
*/

}
