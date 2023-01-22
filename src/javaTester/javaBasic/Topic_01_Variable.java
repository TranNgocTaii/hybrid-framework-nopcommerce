package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {
    static int studentNumber;
    static boolean statusValue;
    static int studentPrice;
    static final String BRWOSER_NAME = "Chrome";

    String studentName = "Automation FC";

    public static void main (String[] args){
        int studentPrice = 5;

        System.out.println(studentPrice);

        System.out.println(studentNumber);
        System.out.println(statusValue);
        System.out.println(Topic_01_Variable.BRWOSER_NAME);
        System.out.println(Topic_01_Variable.statusValue);
        System.out.println(Topic_01_Variable.studentPrice);

        Topic_01_Variable topic_01 = new Topic_01_Variable();
        Topic_01_Variable topic_02 = new Topic_01_Variable();
        Topic_01_Variable topic_03 = new Topic_01_Variable();

        System.out.println(topic_01.studentName);
        System.out.println(topic_01.BRWOSER_NAME);
        System.out.println(topic_02.studentName);
        System.out.println(topic_03.studentName);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();



    }

    //Getter: getCurrentUrl/getTitle/getText/getAttribute/getCssValue/getSize/getLocation/getPosition
    public String getStudentName(){
        return this.studentName;
    }

    //Setter: click/sendkey/clear/select/back/forward/refresh/get/....
    public void setStudentName(String stdName){
        this.studentName =stdName;
    }
}
