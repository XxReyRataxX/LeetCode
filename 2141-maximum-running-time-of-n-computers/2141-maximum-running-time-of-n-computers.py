# @lc code=start
class Solution(object):
    def maxRunTime(self, n, batteries):
        """
        :type n: int
        :type batteries: List[int]
        :rtype: int
        """
        
        # La solución eficiente para este problema es la Búsqueda Binaria sobre el tiempo (T).
        
        # 1. Definir los límites de la búsqueda binaria
        low = 0
        # El tiempo máximo posible es la suma total de toda la energía / el número de ordenadores.
        high = sum(batteries) // n 
        max_time = 0
        
        # 2. Función de verificación: ¿Podemos alimentar 'n' ordenadores durante 'T' minutos?
        def can_run_for_time(T):
            """
            Verifica si la energía total es suficiente para n * T, 
            priorizando el uso de baterías grandes.
            """
            
            # Carga total disponible (efectiva)
            total_charge = 0
            
            for b in batteries:
                # Cada batería solo puede contribuir como máximo T minutos a un ordenador.
                # Si b > T, la energía excedente (b - T) no puede asignarse a otro ordenador 
                # en el tiempo T porque ya estamos en el límite de T.
                # Sumamos la contribución efectiva de cada batería: min(carga, tiempo objetivo T)
                total_charge += min(b, T)
                
            # Comparamos la carga total efectiva con la energía requerida: n * T
            return total_charge >= n * T


        # 3. Búsqueda Binaria
        while low <= high:
            mid = low + (high - low) // 2  # Tiempo T que estamos probando
            
            if can_run_for_time(mid):
                # Si podemos correr por 'mid' tiempo, este es un resultado posible.
                # Guardamos la respuesta y tratamos de ir por un tiempo mayor.
                max_time = mid
                low = mid + 1
            else:
                # 'mid' es demasiado alto. Reducimos el rango superior.
                high = mid - 1
                
        return max_time

# @lc code=end