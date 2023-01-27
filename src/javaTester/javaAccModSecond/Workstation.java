package javaTester.javaAccModSecond;

import javaTester.javaAccModFirst.Computer;

public class Workstation {
    public static void main (String[] args){
        Computer comp = new Computer();

        // Property
        comp.vgaSize = 6;
        System.out.println(comp.vgaSize);

        // Method
        comp.setVgaSize(12);
        System.out.println(comp.vgaSize);

    }

}
