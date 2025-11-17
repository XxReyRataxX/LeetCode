# @lc code=start
class Solution(object):
    def kLengthApart(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        # Inicializa una variable para rastrear el índice del último '1' encontrado.
        # Usa -1 o un valor muy pequeño para indicar que aún no se ha encontrado el primer '1'.
        last_one_index = -1 
        
        for i in range(len(nums)):
            if nums[i] == 1:
                # 1. Si NO es el primer '1' (es decir, last_one_index >= 0)
                if last_one_index != -1:
                    # Calcula la distancia entre el '1' actual (i) y el último '1' (last_one_index).
                    # La distancia son los ceros intermedios.
                    distance = i - last_one_index - 1 
                    
                    # 2. Verifica la condición: la distancia debe ser al menos k.
                    if distance < k:
                        return False # La condición no se cumple.
                
                # 3. Actualiza el índice del último '1' al índice actual (i).
                last_one_index = i
                
        # Si el bucle termina sin devolver False, todos los '1's están separados por al menos k lugares.
        return True

# @lc code=end