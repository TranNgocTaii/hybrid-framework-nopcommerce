package javaTester.javaBasic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {
    int number[] = {5, 8, 100, 11, 60};

    @Test
    public void TC_01_Find_Max_Number(){
        int x = 0;
        for (int i = 0; i < number.length; i++){
            if (x < number[i]){
                x = number[i];
            }
        }
        System.out.println(x);
    }

    @Test
    public void TC_02_Sum_First_And_Last_Number(){
        int x = 0;
        for(int i = 0; i < number.length; i ++){
            System.out.println(x = number[0] + number[number.length-1]);
        }
    }

    @Test
    public void TC_03_Even_Number(){
        for(int i = 0; i < number.length; i ++){
           if (number[i] % 2 == 0){
               System.out.println(number[i]);
           }
        }
    }

    @Test
    public void TC_04(){
        for(int i = 0; i < number.length; i ++){
            if (number[i] >= 0 & number[i] <= 10){
                System.out.println(number[i]);
            }
        }
    }

    @Test
    public void TC_05(){
        int sum = 0;
        for(int i = 0; i < number.length; i ++){
            sum += number[i];
            }
        float average = sum/number.length;
        System.out.println(average);
        }
}
