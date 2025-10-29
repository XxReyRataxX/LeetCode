#
# @lc app=leetcode id=3370 lang=python
#
# [3370] Smallest Number With All Set Bits
#

# @lc code=start
class Solution(object):
    def smallestNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        """Devuelve el número cuyo binario es igual al binario de n pero
        con todos los ceros (dentro del ancho de n) cambiados a 1.

        Ejemplos:
        n = 2  (bin: '10')  -> '11' -> 3
        n = 5  (bin: '101') -> '111' -> 7
        n = 0  (interpretamos '0') -> '1' -> 1
        """
        if n < 0:
            raise ValueError("n debe ser entero no negativo")
        if n == 0:
            return 1
        width = n.bit_length()
        all_ones = (1 << width) - 1
        return all_ones
        
# @lc code=end

