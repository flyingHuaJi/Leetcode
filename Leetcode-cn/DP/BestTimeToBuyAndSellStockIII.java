package DP;

/**
 * @Author: zhouhanming
 * @Date:2021/4/29 10:37 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * 思路：三维 DP
 *
 * 五毒神掌：
 * 第二遍，2021/5/13
 *
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        int[][][] dp = new int[length][3][2];

        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }

        return dp[length - 1][2][0];
    }
}
