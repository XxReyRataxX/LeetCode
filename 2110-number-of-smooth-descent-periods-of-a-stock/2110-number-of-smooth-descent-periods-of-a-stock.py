#
# @lc app=leetcode id=2110 lang=python
#
# [2110] Number of Smooth Descent Periods of a Stock
#

# @lc code=start
class Solution(object):
    def getDescentPeriods(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # Linear pass counting lengths of contiguous descent streaks.
        if not prices:
            return 0

        total = 1  # each single day counts
        streak = 1

        for i in range(1, len(prices)):
            if prices[i] == prices[i - 1] - 1:
                streak += 1
            else:
                streak = 1
            total += streak

        return total
# @lc code=end

