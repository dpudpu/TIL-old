package examples.first.exam01;

public class forTest {
    public static void main(String[] args){

        for(int i=1; i<6; i++){
            for(int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=1; i<6; i++){
            for(int j=i; j<6; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=1; i<6; i++){
            for(int j=i; j<5; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=1; i<6; i++){
            for(int j=i; j<5; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
