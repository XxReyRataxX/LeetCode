#
# @lc app=leetcode id=1578 lang=python
#
# [1578] Minimum Time to Make Rope Colorful
#

# @lc code=start
class Solution(object):
    def minCost(self, colors, neededTime):
        """
        :type colors: str
        :type neededTime: List[int]
        :rtype: int
        """
        # Manteniendo la lógica y variables del autor, pero arreglando el algoritmo:
        # Recorremos la cuerda y cuando hay colores consecutivos iguales, sumamos
        # el tiempo mínimo para eliminar (es decir, eliminamos el más barato).
        coloranterior = ''
        solfin = 0
        # time_prev guarda el tiempo del globo que mantenemos actualmente en la
        # secuencia de colores iguales (el máximo entre vistos hasta ahora).
        time_prev = 0

        for i in range(len(colors)):
            if colors[i] != coloranterior:
                # nuevo color: actualizamos el color anterior y el tiempo guardado
                coloranterior = colors[i]
                time_prev = neededTime[i]
            else:
                # mismo color que el anterior: debemos eliminar uno de los dos
                # añadimos el menor de los dos tiempos al resultado y mantenemos
                # el mayor como time_prev
                if neededTime[i] > time_prev:
                    solfin += time_prev
                    time_prev = neededTime[i]
                else:
                    solfin += neededTime[i]

        return solfin

        
# @lc code=end

