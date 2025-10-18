# @lc app=leetcode id=3397 lang=python
#
# [3397] Maximum Number of Distinct Elements After Operations
#

# @lc code=start
class Solution(object):
    def maxDistinctElements(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        next_available = -float('inf')
        count = 0
        
        for num in nums:
            assigned = max(num - k, next_available)
            if assigned <= num + k:
                count += 1
                next_available = assigned + 1
        
        return count
# @lc code=end
