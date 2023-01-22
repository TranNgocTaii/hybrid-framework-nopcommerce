package javaTester.javaBasic;

public class Topic_03_Compare {
    int number = 8;



    public static void main (String[] args){
        // 1 vung nho cho bien x
        int x = 5;

        //1 vung nho cho bien y
        int y = x;

        System.out.println("x:" + x);
        System.out.println("y:" + y);

        y = 10;

        System.out.println("x:" + x);
        System.out.println("y:" + y);

        Topic_03_Compare firstVariable = new Topic_03_Compare();
//        Topic_03_Compare secondVariable = new Topic_03_Compare();
        Topic_03_Compare secondVariable = firstVariable;

        System.out.println("firstVariable:" + firstVariable.number);
        System.out.println("secondVariable:" + secondVariable.number);

        secondVariable.number = 15;

        System.out.println("firstVariable:" + firstVariable.number);
        System.out.println("secondVariable:" + secondVariable.number);

    }



}
