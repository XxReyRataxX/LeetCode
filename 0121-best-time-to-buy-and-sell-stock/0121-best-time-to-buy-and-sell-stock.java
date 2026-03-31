/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int best = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                best = Math.max(best, prices[i] - min);
            }
        }

        return best;
        
    }
}
// @lc code=end

