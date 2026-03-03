#
# @lc app=leetcode id=1545 lang=python
#
# [1545] Find Kth Bit in Nth Binary String
#

# @lc code=start
class Solution(object):
    def findKthBit(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        s = "0"
        for _ in range(2, n + 1):
            inverted_reversed = "".join("1" if bit == "0" else "0" for bit in reversed(s))
            s = s + "1" + inverted_reversed
        return s[k - 1]



   

        
# @lc code=end

