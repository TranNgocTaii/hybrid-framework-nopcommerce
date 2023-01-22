package javaTester.javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_Excercise {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);

    public void TC_01(){
        int number = scanner.nextInt();

        int afterNumber = number % 2;
        System.out.println(afterNumber);

        boolean status = afterNumber == 0;
        System.out.println(status);

        if ( number % 2 == 0) {
            System.out.println("So: " + number + "la so chan");
        } else{
            System.out.println("So: " + number + "la so le");
        }
    }

    public void TC_02(){
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();

        if( numberA > numberB ) {
            System.out.println( numberA + "lon hon" + numberB );
        } else if ( numberA == numberB ){
            System.out.println( numberA + " bang" + numberB );
        } else {
            System.out.println( numberA + " nho hon" + numberB );
        }
    }

    public void TC_03(){
        String firstStudent = scanner.nextLine();
        String secondStudent = scanner.nextLine();

        // Reference: String
        // Kiem tra cai value cua bien
        // Kiem tra vi tri cua bien trong vung nho

        if (firstStudent.equals(secondStudent)){
            System.out.println("2 sinh vien giong ten nhau");
        } else {
            System.out.println("2 sinh vien khac ten nhau");

        }

        if (firstStudent == secondStudent){
            System.out.println("2 sinh vien giong ten nhau");
        } else {
            System.out.println("2 sinh vien khac ten nhau");
        }
    }

    public void TC_04(){
        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        int numberC = scanner.nextInt();

        if(numberA > numberB && numberA > numberC){
            System.out.println(numberA +" la so lon nhat");
        } else if (numberB > numberC){
            System.out.println(numberB +" la so lon nhat");
        } else {
            System.out.println(numberC +" la so lon nhat");
        }
    }

    public void TC_05(){
        int numberA = scanner.nextInt();

        if (10 < numberA && numberA < 100){
            System.out.println(numberA + "nam trong khoang 10 den 100");
        } else {
            System.out.println(numberA + "nam ngoai khoang 10 den 100");
        }
    }

    public void TC_06(){
        int studentPoint = scanner.nextInt();

        if (studentPoint <= 10 && studentPoint >=8.5){
            System.out.println("He so A");
        } else if (studentPoint < 8.5 && studentPoint >= 7.5){
            System.out.println("He so B");
        } else if(studentPoint < 7.5 && studentPoint >= 5){
            System.out.println("He so C");
        } else if (studentPoint < 5 && studentPoint >=0){
            System.out.println("He so D");
        } else {
            System.out.println("Ban vui long nhap diem lai");
        }
    }

    public void TC_07(){
        int month = scanner.nextInt();

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            System.out.println("Thang nay co 31 ngay");
        } else if (month ==2){
            System.out.println("Thang nay co 28 ngay");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Thang nay co 30 ngay");
        }
    }

}
