package algorithm.leetcode.dinamic;

public class Quiz746 {
    public static int minCostClimbingStairs(int[] cost) {
        int max = cost.length;
        int num1=cost[0], num2=cost[1];
        for (int i = 2; i < max; i++) {
            int temp = cost[i] + Math.min(num1,num2);
            num1=num2;
            num2=temp;
        }

        return Math.min(num1,num2);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost2));
    }
}
