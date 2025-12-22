# @lc app=leetcode id=643 lang=python
#
# [643] Maximum Average Subarray I
#

# @lc code=start

class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        # 1. Calculamos la suma de la primera ventana de tamaño k
        suma_actual = sum(nums[:k])
        max_suma = suma_actual
        
        # 2. Deslizamos la ventana por el resto del array
        # Empezamos desde el índice k hasta el final
        for i in range(k, len(nums)):
            # Sumamos el nuevo elemento que entra y restamos el que sale
            suma_actual += nums[i] - nums[i-k]
            
            # Guardamos la suma más grande que hayamos visto
            if suma_actual > max_suma:
                max_suma = suma_actual
        
        # 3. La media máxima es la suma máxima dividida por k
        # Convertimos a float para asegurar precisión decimal
        return float(max_suma) / k

# @lc code=end