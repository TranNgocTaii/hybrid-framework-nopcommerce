package javaTester.javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

// Class
public class Topic_09_While_Do_While {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_For(){
        int number = scanner.nextInt();
        for (int i = number; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    @Test
    public void TC_02_While(){
        int number = scanner.nextInt();

        while (number <100){
            if (number % 2 == 0 ){
                System.out.println(number);
            }
        }
    }

    @Test
    public void TC_03_Do_While(){
        int number = scanner.nextInt();

        do {
            if (number % 2 == 0){
                System.out.println(number);
                number++;
            }
        } while (number < 100);
    }

    @Test
    public void TC_04_While(){
        int numberA = scanner.nextInt();


        while (numberA < 100){
            if (numberA % 3 == 0 && numberA % 5 == 0  ) {
                System.out.println(numberA);
            }
                numberA++;
            }
        }

    @Test
    public void TC_05_While(){
        int numberA = scanner.nextInt();
        int i = 0;

        while (numberA > 0){
            if (numberA % 2 != 0 ) {
                i += numberA;
            }
            numberA--;
        }
        System.out.println(i);
    }

    public void TC_06_While(){
        int numberA = scanner.nextInt();
        int i = 1;

        while (numberA > 0){
            {
                i *= numberA;
            }
            numberA--;
        }
        System.out.println(i);
    }

    }

