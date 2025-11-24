# @lc app=leetcode id=2243 lang=python
#
# [2243] Calculate Digit Sum of a String
#

# @lc code=start
class Solution(object):
    def digitSum(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        resultado = s
        while len(resultado) > k:
            nuevo = ""
            for i in range(0, len(s), k):
                bloque = s[i:i+k]
                total = sum(int(c) for c in bloque)
                nuevo += str(total)
            s = nuevo
            resultado = s

        return resultado

# @lc code=end
