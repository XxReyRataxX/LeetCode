class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        
        Calcula el producto de todos los elementos de nums excepto nums[i],
        en tiempo O(n) y sin usar la operación de división.

        La estrategia consiste en dos pases:
        1. Pase de izquierda a derecha para calcular los productos de prefijo.
        2. Pase de derecha a izquierda para calcular los productos de sufijo y la respuesta final.
        """
        n = len(nums)
        
        # 'answer' inicialmente almacena los productos de prefijo (elementos a la izquierda de i).
        answer = [0] * n
        
        # 1. **Pase 1: Calcular Productos de Prefijo (Izquierda)**
        # El producto a la izquierda del índice 0 es 1.
        answer[0] = 1
        
        # Iteramos desde el índice 1 hasta el final
        for i in range(1, n):
            # El producto a la izquierda de 'i' es el producto a la izquierda de 'i-1' 
            # multiplicado por el elemento en 'i-1'.
            answer[i] = answer[i-1] * nums[i-1]
            
        # Ejemplo con [1, 2, 3, 4]: answer = [1, 1, 2, 6]

        # 2. **Pase 2: Calcular Productos de Sufijo (Derecha) y la Respuesta Final**
        
        # 'right_product' almacena el producto acumulado de los sufijos.
        right_product = 1
        
        # Iteramos hacia atrás, desde el último índice hasta el índice 0
        for i in range(n - 1, -1, -1):
            # Paso A: El resultado final es (Producto Izquierdo) * (Producto Derecho).
            # answer[i] ya contiene el Producto Izquierdo.
            answer[i] = answer[i] * right_product
            
            # Paso B: Actualizamos el producto de sufijo para la siguiente iteración (a la izquierda).
            right_product = right_product * nums[i]
            
        return answer

# Ejemplos de prueba (usando la clase):
# solver = Solution()
# print(solver.productExceptSelf([1, 2, 3, 4]))      # Salida esperada: [24, 12, 8, 6]
# print(solver.productExceptSelf([-1, 1, 0, -3, 3])) # Salida esperada: [0, 0, 9, 0, 0]