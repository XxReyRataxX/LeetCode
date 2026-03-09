#
# @lc app=leetcode id=3129 lang=python
#
# [3129] Find All Possible Stable Binary Arrays I
#

# @lc code=start
class Solution(object):
    def numberOfStableArrays(self, zero, one, limit):
        """
        :type zero: int
        :type one: int
        :type limit: int
        :rtype: int
        """
        mod = 10 ** 9 + 7
        # end0[i][j]: arrays with i zeros and j ones ending in 0
        # end1[i][j]: arrays with i zeros and j ones ending in 1
        end0 = [[0] * (one + 1) for _ in range(zero + 1)]
        end1 = [[0] * (one + 1) for _ in range(zero + 1)]

        for i in range(1, min(zero, limit) + 1):
            end0[i][0] = 1
        for j in range(1, min(one, limit) + 1):
            end1[0][j] = 1

        for i in range(1, zero + 1):
            for j in range(1, one + 1):
                val0 = end0[i - 1][j] + end1[i - 1][j]
                if i - limit - 1 >= 0:
                    val0 -= end1[i - limit - 1][j]
                end0[i][j] = val0 % mod

                val1 = end0[i][j - 1] + end1[i][j - 1]
                if j - limit - 1 >= 0:
                    val1 -= end0[i][j - limit - 1]
                end1[i][j] = val1 % mod

        return (end0[zero][one] + end1[zero][one]) % mod
# @lc code=end

