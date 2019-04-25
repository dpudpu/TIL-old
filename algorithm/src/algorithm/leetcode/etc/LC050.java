package algorithm.leetcode.etc;

public class LC050 {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
    }
}
