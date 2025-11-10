#
# @lc app=leetcode id=3542 lang=python
#
# [3542] Minimum Operations to Convert All Elements to Zero
#

# @lc code=start
class Solution(object):
    def minOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
    # Solución eficiente basada en pila (O(n)).
    # Idea: recorremos el array de izquierda a derecha manteniendo una pila de valores
    # estrictamente crecientes (ignorando los ceros).
    # Si el valor actual es menor que la cima, desapilamos valores mayores. Si el valor
    # actual es mayor que la cima (y distinto de 0), necesitamos una nueva operación para
    # ese valor en el segmento actual. Esto cuenta el número mínimo de operaciones.
        stack = []
        ops = 0
        for a in nums:
            # pop values greater than current
            while stack and stack[-1] > a:
                stack.pop()

            if a == 0:
                # zeros don't need operations and act as segment separators
                continue

            # if current value is new in this segment, push and count an operation
            if not stack or stack[-1] < a:
                stack.append(a)
                ops += 1

        return ops
            
# @lc code=end

