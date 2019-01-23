package algorithm.leetcode.dinamic;

public class Fibonacci {
    public static int fib(int n) {
        if(n==0)
            return 0;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i - 1]+memo[i-2];

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
