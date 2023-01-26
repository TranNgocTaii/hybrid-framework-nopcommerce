package javaTester.javaBasic;

public class Topic_10_Break_Continue {

    // Nested for
    public static void main (String[] args){
        for (int i = 1; i <= 5; i++){
            System.out.println("Lan chay cua i(for tren): " +i);

            for(int j = 1; j <=5; j++){
                if (j == 4){
                    continue;
                }
                System.out.println("j:" +j);

                for(int x = 1; x <=5; x++){
                    if (x ==4){
                        continue;
                    }
                    System.out.println("x: " +x);
                }
            }
        }
    }
}
