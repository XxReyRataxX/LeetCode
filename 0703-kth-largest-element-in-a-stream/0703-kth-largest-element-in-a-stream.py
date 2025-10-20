class KthLargest(object):
    """
    Implementación basada en ordenar toda la lista en cada llamada a 'add'.
    Esta solución es menos eficiente que la de Min-Heap para grandes flujos de datos.
    """
    
    def __init__(self, k, nums):
        """
        Inicializa el objeto.
        
        :type k: int
        :type nums: List[int]
        """
        
        self.k = k
        # Guarda la lista inicial de números como atributo de la instancia
        self.nums = nums
        

    def add(self, val):
        """
        Añade un nuevo valor 'val' y devuelve el K-ésimo elemento más grande actual.
        
        :type val: int
        :rtype: int
        """
        
        # 1. Añadir el nuevo valor a la lista de la instancia.
        self.nums.append(val)
        
        # 2. Ordenar la lista completa de mayor a menor.
        #    Usamos 'self.nums' para asegurarnos de que estamos ordenando
        #    el atributo de la clase, no una variable local sin definir.
        #    sorted() devuelve una *nueva* lista ordenada.
        self.nums = sorted(self.nums, reverse=True)
        
        # 3. El K-ésimo elemento más grande es el elemento en la posición k-1 
        #    en una lista ordenada de mayor a menor (ya que los índices empiezan en 0).
        #    Ejemplo: Si k=3, necesitamos el índice 2.
        
        # Es crucial que la lista tenga al menos k elementos, lo cual el problema garantiza
        # para cuando se llama a 'add' y se espera una respuesta.
        if len(self.nums) < self.k:
             # Si no hay suficientes elementos para el K-ésimo, devolvemos un mensaje o error
             # (En LeetCode, esto no debería pasar si se sigue el flujo del problema).
             return None 
             
        return self.nums[self.k - 1]


# Ejemplo de uso:
# k = 3
# nums = [4, 5, 8, 2]
# obj = KthLargest(k, nums) 

# print(obj.add(3)) # Salida esperada: 4 
# print(obj.add(5)) # Salida esperada: 5 
# print(obj.add(10)) # Salida esperada: 5 
