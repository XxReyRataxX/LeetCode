#
# @lc app=leetcode id=2154 lang=python
#
# [2154] Keep Multiplying Found Values by Two
#

# @lc code=start
class Solution(object):
    def findFinalValue(self, nums, original):
        """
        :type nums: List[int]
        :type original: int
        :rtype: int
        """
        encontrado = True
        while encontrado:
            if original in nums:
                original = original * 2
            else:
                encontrado = False

        return original
        
# @lc code=end

