package algorithm.leetcode.dinamic;

import java.util.Arrays;
import java.util.Collections;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
121. Best Time to Buy and Sell Stock
 */
public class Quiz121 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
//        //Brute Force O(n 2);
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                int profit = prices[j] - prices[i];
//                maxProfit = maxProfit > profit ? maxProfit : profit;
//            }
//        }

        for (int i = 0; i < prices.length; i++) {
            minPrice = minPrice < prices[i] ? minPrice : prices[i];

            maxProfit = maxProfit > prices[i] - minPrice ? maxProfit : prices[i] - minPrice;
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int[] input = {2, 4, 1};
        System.out.println(maxProfit(input));
    }
}
