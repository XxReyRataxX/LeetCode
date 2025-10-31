#
# @lc app=leetcode id=3289 lang=python
#
# [3289] The Two Sneaky Numbers of Digitville
#

# @lc code=start
class Solution(object):
    def getSneakyNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        solucion = []
        nums.sort()

        for i in range(len(nums)):
            if (i+1) in range(len(nums)):
                if nums[i] == nums[i+1]:
                    solucion.append(nums[i])
        

        return solucion

# @lc code=end

