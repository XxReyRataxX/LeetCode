class Solution(object):
    def intersectionSizeTwo(self, intervals):
        # Ordenar por end asc; si tie, start desc
        intervals.sort(key=lambda x: (x[1], -x[0]))
        
        # x < y serán los dos últimos números añadidos
        x, y = -1, -1
        ans = 0
        
        for a, b in intervals:
            if a > y:
                # no elementos en común: añadimos b-1, b
                ans += 2
                x, y = b-1, b
            elif a > x:
                # hay exactamente uno (y), añadimos b
                ans += 1
                x, y = y, b
            else:
                # ya tenemos al menos dos elementos en [a,b]
                continue
        return ans
