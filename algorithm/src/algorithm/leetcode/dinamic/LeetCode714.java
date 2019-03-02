package algorithm.leetcode.dinamic;

public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        int prices[] = {1, 4, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(new LeetCode714().maxProfit(prices, fee));
    }
}
