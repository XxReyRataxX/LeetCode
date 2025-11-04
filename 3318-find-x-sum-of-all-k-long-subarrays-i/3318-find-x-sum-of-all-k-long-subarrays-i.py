#
# @lc app=leetcode id=3318 lang=python
#
# [3318] Find X-Sum of All K-Long Subarrays I
#

# @lc code=start
class Solution(object):
    def findXSum(self, nums, k, x):
        """
        :type nums: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n = len(nums)
        if n == 0 or k == 0:
            return []
        BufferSize = n - k + 1
        buffer = [0] * BufferSize

        # Ventana deslizante simple: para seguir tu lógica, construimos
        # apariencias (lista de tuplas (num, count)) para cada subarray.
        for posicion in range(0, BufferSize):
            aux = nums[posicion: posicion + k]       # subarray
            # contar apariciones
            counts = {}
            for v in aux:
                counts[v] = counts.get(v, 0) + 1

            # convertir a lista de (num, count) y ordenar por (count desc, num desc)
            apariencias = list(counts.items())      # (num, count)
            apariencias.sort(key=lambda t: (-t[1], -t[0]))

            # sumar los top x elementos (si hay menos, se suman todos)
            total = 0
            taken = 0
            for num, cnt in apariencias:
                if taken >= x:
                    break
                total += num * cnt
                taken += 1

            buffer[posicion] = total

        return buffer
# @lc code=end

