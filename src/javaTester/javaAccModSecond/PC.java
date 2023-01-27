package javaTester.javaAccModSecond;

import javaTester.javaAccModFirst.Computer;

public class PC extends Computer {

    public void showCpuProductName() {
        // Property
        vgaSize = 6;
        System.out.println(vgaSize);

        // Method
        setVgaSize(12);
        System.out.println(vgaSize);

    }
}
