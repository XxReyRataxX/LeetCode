#
# @lc app=leetcode id=1071 lang=python
#
# [1071] Greatest Common Divisor of Strings
#

# @lc code=start
class Solution(object):
    def gcdOfStrings(self, str1, str2):
        """
        :type str1: str
        :type str2: str
        :rtype: str
        If str1+str2 != str2+str1 there is no common divisor string.
        Otherwise the gcd string has length gcd(len(str1), len(str2))
        and is the prefix of str1 of that length.
        """
        if str1 + str2 != str2 + str1:
            return ""

        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        g = gcd(len(str1), len(str2))
        return str1[:g]

# @lc code=end

