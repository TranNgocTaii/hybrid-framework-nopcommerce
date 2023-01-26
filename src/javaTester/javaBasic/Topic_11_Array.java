package javaTester.javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

    public static void main (String[] args){

        int number [] = {10, 12, 7, 5, 6, 15};
        int[] student = {10, 12, 7, 5, 6, 15};
        System.out.println(student[0]);
        System.out.println(student[1]);

        // Duoc define co dinh bao nhieu phan tu khi viet code (compile)
        String studentName[] = {"Tai", "Nam", "Long"};
        studentName[0] = "Hoa";
        String studentNewName[] = studentName.clone();

        int b[] = new int[10];
        b[0] = 10;

        for (int i = 0; i <studentName.length; i++){
            if (studentName[i].equals("Long")){
                System.out.println("Click on Long");
            }
        }

        // Khong ket hop voi dieu kien
        for (String students : studentName){
            if (students.equals("Long")){
                System.out.println("Click on Long");
            }
        }

        ArrayList<String> stdName = new ArrayList<String>();

        // Khi chay code moi add (Runtime)
        for (String std : studentName){
            stdName.add(std);
        }

        List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
        for (String name :names){
            System.out.println("Name: " + name);
        }

        String std_Name = Arrays.toString(studentName);
    }
}
