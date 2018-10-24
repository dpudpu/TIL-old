package algorithm.doit.examples.chap05;

public class Q2 {
    public static void main(String args[]) {
        System.out.println("두 정수의 최대공약수 구하기 : " + gcd(2, 5));
    }

    static int gcd(int x, int y) {
        int tmp;

        while (y > 0) {
            System.out.println(x+" / "+y);
            tmp = y;
            y = x%y;
            x = tmp;
        }
        return x;
    }
}
