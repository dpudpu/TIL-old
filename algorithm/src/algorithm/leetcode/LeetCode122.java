package algorithm.leetcode;

public class LeetCode122 {
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int prices[] = {1,2,3,2,9};
        System.out.println(maxProfit(prices));
    }
}
