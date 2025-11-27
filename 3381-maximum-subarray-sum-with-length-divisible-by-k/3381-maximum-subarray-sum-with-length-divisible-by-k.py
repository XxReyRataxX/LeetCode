class Solution(object):
    def maxSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        N = len(nums)
        
        # 1. Calcular el arreglo de Sumas de Prefijo (P)
        # P[i] es la suma de nums[0] a nums[i-1]. P tiene longitud N + 1.
        # P[0] = 0.
        P = [0] * (N + 1)
        for i in range(N):
            P[i+1] = P[i] + nums[i]
        
        # Inicialización de la Suma Máxima
        # Un valor suficientemente pequeño. Si el subarreglo más largo es negativo,
        # su suma debe ser menor o igual a -k (si los elementos son -10^9) 
        # o -10^5 * 10^9. Usamos una suma muy pequeña.
        # El problema nos garantiza que k >= 1 y nums.length >= 1, por lo que siempre
        # existe un subarreglo, aunque su suma sea muy negativa.
        # El mínimo posible es (2 * 10^5) * (-10^9) ≈ -2 * 10^14.
        # Inicializamos con el mínimo posible.
        
        # La suma máxima DEBE ser inicializada de forma que pueda ser reemplazada
        # por cualquier suma válida. Si solo hay elementos negativos,
        # la suma máxima será negativa. Usaremos -float('inf').
        max_sum = -float('inf') 
        
        # 2. Inicializar la tabla de mínimos de Suma de Prefijo por Módulo (M)
        # M[r] = mínimo valor de P[i] tal que i % k == r.
        # Inicializamos con float('inf') para indicar que aún no hemos visto un prefijo con ese residuo.
        min_prefix_sum_mod = [float('inf')] * k
        
        # Caso base: P[0] = 0, y 0 % k == 0.
        min_prefix_sum_mod[0] = 0
        
        # 3. Iteración y Actualización
        # Iteramos sobre P[i] desde i = 1 hasta N. (P[i] es la suma hasta el índice i-1 en nums)
        for i in range(1, N + 1):
            
            # r es el residuo del índice actual
            r = i % k
            
            # Paso A: Cálculo de la Suma Potencial Máxima
            # Si ya hemos visto un prefijo P[j] con el mismo residuo 'r',
            # la suma P[i] - min_prefix_sum_mod[r] es la suma del subarreglo
            # con longitud (i - j) que es divisible por k.
            if min_prefix_sum_mod[r] != float('inf'):
                current_sum = P[i] - min_prefix_sum_mod[r]
                max_sum = max(max_sum, current_sum)
            
            # Paso B: Actualizar la Tabla de Mínimos
            # Actualizamos el valor mínimo de P[i] visto para este residuo 'r'.
            min_prefix_sum_mod[r] = min(min_prefix_sum_mod[r], P[i])
            
        # 4. Devolver la Suma Máxima
        # Si max_sum sigue siendo -float('inf'), implica que N=0, pero las restricciones
        # garantizan N >= 1, por lo que este caso no debería ocurrir.
        return max_sum

# Ejemplo de uso (Opcional, no parte de la clase pedida):
# solver = Solution()
# print(solver.maxSubarraySum([1, 2], 1)) # Output: 3
# print(solver.maxSubarraySum([-1,-2,-3,-4,-5], 4)) # Output: -10
# print(solver.maxSubarraySum([-5, 1, 2, -3, 4], 2)) # Output: 4