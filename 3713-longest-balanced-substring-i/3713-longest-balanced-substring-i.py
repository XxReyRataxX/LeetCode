#
# @lc app=leetcode id=3713 lang=python
#
# [3713] Longest Balanced Substring I
#

# @lc code=start
class Solution(object):
    def longestBalanced(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        best = 0

        for i in range(n):
            counts = [0] * 26
            distinct = 0
            max_count = 0

            for j in range(i, n):
                idx = ord(s[j]) - ord("a")
                if counts[idx] == 0:
                    distinct += 1
                counts[idx] += 1
                if counts[idx] > max_count:
                    max_count = counts[idx]

                length = j - i + 1
                if length % distinct != 0:
                    continue

                # All non-zero counts must match.
                min_count = 10**9
                for c in counts:
                    if c:
                        if c < min_count:
                            min_count = c
                        if c != max_count:
                            min_count = -1
                            break

                if min_count != -1 and min_count == max_count:
                    if length > best:
                        best = length

        return best



# @lc code=end

