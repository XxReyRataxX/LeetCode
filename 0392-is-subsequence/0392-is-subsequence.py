#
# @lc app=leetcode id=392 lang=python
#
# [392] Is Subsequence
#

# @lc code=start
class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        encontrado = 0
        if len(s) == 0:
            return True

        for i in range(len(t)):
            if t[i] == s[encontrado]:
                
                encontrado+=1
                if encontrado == len(s):
                    return True
        
        return False
            
        
# @lc code=end

