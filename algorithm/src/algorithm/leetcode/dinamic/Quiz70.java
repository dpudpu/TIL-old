package algorithm.leetcode.dinamic;

/*
https://leetcode.com/problems/climbing-stairs/
70. Climbing Stairs
 */
public class Quiz70 {

    public static int climbStairs(int n) {
        if(n==1)
            return 1;

        int[] memo = new int[n];

        memo[0] = 1;
        memo[1] = 2;

        for (int i = 2; i < n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];

        return memo[n-1];

//        return climb( n, memo);
    }

//    public static int climb(int n, int[] memo){
//       if(n==0)
//           return 1;
//       if(n<0)
//           return 0;
//       if(memo[n-1] > 0)
//           return memo[n-1];
//       memo[n-1] = climb(n-1,memo)+climb(n-2,memo);
//
//        return memo[n-1];
//    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
