#
# @lc app=leetcode id=3346 lang=python
#
# [3346] Maximum Frequency of an Element After Performing Operations I
#

# @lc code=start
from collections import Counter, defaultdict

class Solution(object):
    def maxFrequency(self, nums, k, numOperations):
        """
        :type nums: List[int]
        :type k: int
        :type numOperations: int
        :rtype: int
        """
        if not nums:
            return 0

        cnt = Counter(nums)

        # eventos para sweep line: +1 en (a-k), -1 en (a+k+1) (intervalos inclusivos [a-k, a+k])
        events = defaultdict(int)
        for a in nums:
            events[a - k] += 1
            events[a + k + 1] -= 1
            # aseguramos que la posición 'a' esté en las claves para evaluar equals allí
            events[a] += 0

        positions = sorted(events.keys())
        curr_overlap = 0
        res = 0

        for pos in positions:
            curr_overlap += events[pos]

            # en cualquier punto dentro del segmento que empieza en `pos` la solapación es curr_overlap
            # si no hay elementos exactamente ahí, la mejor que podemos lograr sin equals es:
            res = max(res, min(curr_overlap, numOperations))

            # si hay elementos exactamente iguales a 'pos', evalúalos:
            equals = cnt.get(pos, 0)
            if equals:
                convertible_excl_equals = curr_overlap - equals
                possible = equals + min(convertible_excl_equals, numOperations)
                res = max(res, possible)

        # en casos donde ya hay elementos iguales y no necesitamos operaciones, res puede ser >=1
        return max(res, 1)
# @lc code=end
