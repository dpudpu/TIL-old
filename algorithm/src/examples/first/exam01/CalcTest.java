package examples.first.exam01;

public class CalcTest {
    public static void main(String args[]){
        Calc cal1= new Calc();

        System.out.println(cal1.getValue());

        cal1.plus(500);

        System.out.println(cal1.getValue());

        cal1.plus(100);

        System.out.println(cal1.getValue());

        cal1.sub(50);
        System.out.println("-50 = "+cal1.getValue());

        cal1.mul(15);
        System.out.println("*50="+cal1.getValue());

        cal1.div(5);
        System.out.println("/50="+cal1.getValue());

        cal1.clear();
        System.out.println(cal1.getValue());

    }
}
