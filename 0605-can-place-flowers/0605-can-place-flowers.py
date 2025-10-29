#
# @lc app=leetcode id=605 lang=python
#
# [605] Can Place Flowers
#

# @lc code=start
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        # Greedy approach: scan left-to-right and plant whenever the
        # current plot is empty and both neighbors (if they exist)
        # are empty. No while loop is needed – a single pass suffices.
        planted = 0
        m = len(flowerbed)
        for i in range(m):
            if planted >= n:
                break
            if flowerbed[i] == 0:
                left_empty = (i == 0) or (flowerbed[i-1] == 0)
                right_empty = (i == m-1) or (flowerbed[i+1] == 0)
                if left_empty and right_empty:
                    flowerbed[i] = 1
                    planted += 1

        return planted >= n
                        


                
                    
# @lc code=end

