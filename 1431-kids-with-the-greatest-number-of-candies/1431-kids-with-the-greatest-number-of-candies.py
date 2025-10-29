#
# @lc app=leetcode id=1431 lang=python
#
# [1431] Kids With the Greatest Number of Candies
#

# @lc code=start
class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        resultados = [False]*len(candies)
        max = 0
        for i in range(len(candies)):
            if candies[i] > max:
                max = candies[i]
                
        for j in range(len(candies)):
            if (candies[j] + extraCandies) >= max:
                resultados[j]=True

        return resultados
# @lc code=end

