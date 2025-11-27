from collections import Counter

class Solution(object):
    def maxOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # 1. Contar la frecuencia de cada número
        frecuencias = Counter(nums)
        operaciones = 0
        
        # 2. Iterar sobre los números únicos y sus frecuencias
        for x in frecuencias:
            y = k - x  # La pareja que necesitamos

            # Caso 1: Los números son diferentes (x != y)
            if x < y:
                # Obtenemos la frecuencia de x y la de y
                frecuencia_x = frecuencias[x]
                frecuencia_y = frecuencias.get(y, 0) # Usamos .get para manejar si 'y' no existe

                # El número de pares es limitado por el número menos frecuente
                pares_a_formar = min(frecuencia_x, frecuencia_y)
                operaciones += pares_a_formar

            # Caso 2: El número es igual a su pareja (x == y)
            # Esto significa que x + x = k, o x = k/2.
            # Necesitamos dos ocurrencias de x para formar un par.
            elif x * 2 == k:
                frecuencia_x = frecuencias[x]
                
                # El número de pares es la mitad de la frecuencia
                # // es división entera
                operaciones += frecuencia_x // 2
                
        return operaciones