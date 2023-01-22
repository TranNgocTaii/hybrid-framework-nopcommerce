package javaTester.javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {

    public static void main (String[] args){
        int number = 10;
        number +=5;
        System.out.println(number);

        // 15 / 5 = 3
        System.out.println(number/5);

        // 15 % 6 = 2 du 3

        System.out.println(number%6);

        System.out.println(number++);
        System.out.println(number--);

        System.out.println(number++);
        // In number ra truoc: 10
        // ++: tang number len 1 = 11

        System.out.println(++number);
        // ++ truoc: tang number len 1 = 12
        // In number ra: 12

        for(int i = 0; i < 3; i++){
            System.out.println(i);
        }

        Assert.assertTrue(5<6);
        String address = "Ho Chi Minh";

        if (!(address == "Ha Noi")){
            System.out.println("Address is the same");
        }

        boolean status = ( address == "Ha Noi") ? true : false;
        System.out.println(status);



    }


}
