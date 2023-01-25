package javaTester.javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Switch_Case {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);

    @Test
    @Parameters("browser")
    public void TC_01_Switch_Case(String browserName) {
        driver = getBrowserDriver(browserName);
        System.out.println(browserName);
        driver.quit();
    }

    public void TC_02() {
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Thang nay co 31 ngay");
                break;
            case 2:
                System.out.println("Thang nay co 28 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Thang nay co 30 ngay");
                break;
            default:
                System.out.println("Thang vua nhap sai dinh dang");
                break;
        }
    }

    public void TC_03() {
        int iNumber = scanner.nextInt();
        switch (iNumber) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
        }
    }

    public void TC_04() {
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        String operator = scanner.next();

        switch (operator) {
            case "+":
                System.out.println(numberA + numberB);
                break;
            case "-":
                System.out.println(numberA - numberB);
                break;
            case "*":
                System.out.println(numberA * numberB);
                break;
            case "/":
                System.out.println(numberA / numberB);
                break;
            case "%":
                System.out.println(numberA % numberB);
                break;
        }
    }

        public WebDriver getBrowserDriver (String browserName){
            switch (browserName) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
                    driver = new EdgeDriver();
                    break;
                default:
                    new RuntimeException("Please input correct the browser name");
                    break;
            }
            return driver;
        }
    }