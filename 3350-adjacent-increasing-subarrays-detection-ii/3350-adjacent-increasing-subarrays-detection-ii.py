# @lc app=leetcode id=3350 lang=python
#
# [3350] Adjacent Increasing Subarrays Detection II
#

# @lc code=start
class Solution(object):
    def maxIncreasingSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        left = [1] * n  # longitud del subarray creciente que termina en i
        right = [1] * n  # longitud del subarray creciente que empieza en i

        # Calcular subarrays crecientes hacia la izquierda
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                left[i] = left[i - 1] + 1

        # Calcular subarrays crecientes hacia la derecha
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                right[i] = right[i + 1] + 1

        ans = 0
        # Buscar punto de corte entre dos subarrays adyacentes
        for i in range(1, n):
            ans = max(ans, min(left[i - 1], right[i]))

        return ans
# @lc code=end
