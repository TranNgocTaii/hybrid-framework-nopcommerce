package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_Foreach {
    WebDriver driver;

    public void TC_01_For_Interate() {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

//        List<WebElement> links = driver.findElements(By.xpath(""));
//        links.size();


        // Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"};

        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                System.out.println(cityName[i]);
            }
        }
        int y = 0;
        for (String city : cityName){

        }
    }

    @Test
    public void TC_02_ForEach(){
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho","Hai Phong","Khanh Hoa"};



        // Java Collection
        // Class: ArrayList / LinkedList / Vector /....
        //Interface: List / Set / Queue
        List <String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        // Compile (Coding)
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa pa");
        System.out.println(cityAddress.size());


        // Runtime (Running)
        for (String city : cityName){
            cityAddress.add(city);
        }
        System.out.println(cityAddress.size());

        for ( String cityAdd : cityAddress){
            System.out.println(cityAdd);
        }

        // Java Generic
        List <WebElement> buttons = driver.findElements(By.xpath(""));

        // Xu li du lieu / get text / value / css / attribute
        for (WebElement button : buttons){
            // Chuyen page
            // Refresh DOM / HTML
            // Ko con ton tai
            // Fail -> staleEleentException
        }

    }





}
