#
# @lc app=leetcode id=1980 lang=python
#
# [1980] Find Unique Binary String
#

# @lc code=start
class Solution(object):
    def findDifferentBinaryString(self, nums):
        """
        :type nums: List[str]
        :rtype: str
        """
        if len(nums) == 0:
            return ""

        n = len(nums[0])
        datos = ['0'] * n

        while True:
            s = ''.join(datos)
            if s not in nums:
                return s

            # Incrementa el arreglo de caracteres como un contador binario.
            i = n - 1
            while i >= 0 and datos[i] == '1':
                datos[i] = '0'
                i -= 1

            if i < 0:
                return ""

            datos[i] = '1'


        
# @lc code=end

