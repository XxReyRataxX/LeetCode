class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #solucion greedy, cogemos el menor actual en esta iteración
        c1 = 1000000
        c2 = 0
        for i in range(len(nums)):            
            if nums[i] < c1:
                c1=nums[i]
                if c1 > c2:
                    aux = c2
                    c2 = c1
                    c1 = aux
            if nums[i] > c2:
             return True

        return False      
