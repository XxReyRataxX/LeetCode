# @lc app=leetcode id=2598 lang=python
#
# [2598] Smallest Missing Non-negative Integer After Operations
#

# @lc code=start
class Solution(object):
    def findSmallestInteger(self, nums, value):
        """
        :type nums: List[int]
        :type value: int
        :rtype: int
        """
        # 1️⃣ Calculamos los restos positivos (mod value)
        restos = [(num % value + value) % value for num in nums]

        # 2️⃣ Contamos cuántos hay de cada resto
        counts = {}
        for r in restos:
            counts[r] = counts.get(r, 0) + 1

        # 3️⃣ Recorremos 0, 1, 2, 3... hasta que no podamos formar ese número
        i = 0
        while True:
            r = i % value  # el resto que necesitamos
            if counts.get(r, 0) > 0:
                counts[r] -= 1  # usamos uno de ese tipo
                i += 1
            else:
                return i
# @lc code=end
