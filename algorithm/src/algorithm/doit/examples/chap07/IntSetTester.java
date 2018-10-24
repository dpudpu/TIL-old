package algorithm.doit.examples.chap07;

public class IntSetTester {
    public static void main(String[] args){
        IntSet s1 = new IntSet(20);
        IntSet s2 = new IntSet(20);
        IntSet s3 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(35);

        s3.copyFrom(s2);
        s3.add(10);

        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println("s3="+s3);
    }
}
