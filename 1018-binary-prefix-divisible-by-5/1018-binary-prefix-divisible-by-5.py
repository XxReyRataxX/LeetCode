class Solution(object):
    def prefixesDivBy5(self, nums):
        res = []
        actual = 0  # este será el valor parcial % 5

        for bit in nums:
            actual = (actual * 2 + bit) % 5
            res.append(actual == 0)

        return res
