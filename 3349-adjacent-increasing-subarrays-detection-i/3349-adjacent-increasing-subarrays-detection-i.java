# @lc app=leetcode id=3349 lang=python
#
# [3349] Adjacent Increasing Subarrays Detection I
#

# @lc code=start
class Solution(object):
    def hasIncreasingSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """

        n = len(nums)
        contador = 0
        contador2 = 0

        if k == 1:
            return True
        else:
            for i in range(n - 2 * k + 1):  # aseguramos espacio para 2 subarrays
                j = i + 1
                contador = 1

                # contar subarray creciente desde i hasta i + k - 1
                while j < i + k and j < n and nums[j] > nums[j - 1]:
                    contador += 1
                    j += 1

                if contador == k:
                    # si el primer subarray fue creciente, comprobar el siguiente
                    x = i + k
                    llegar = x + 1
                    contador2 = 1

                    while llegar < x + k and llegar < n and nums[llegar] > nums[llegar - 1]:
                        contador2 += 1
                        llegar += 1

                    if contador2 == k:
                        return True

            return False
# @lc code=end
