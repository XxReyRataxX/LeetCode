# @lc app=leetcode id=960 lang=python
#
# [960] Delete Columns to Make Sorted III
#

# @lc code=start
class Solution(object):
    def minDeletionSize(self, strs):
        n = len(strs)       # Número de filas (palabras)
        m = len(strs[0])    # Número de columnas (letras por palabra)
        
        # dp[j] almacenará la longitud de la secuencia más larga de 
        # columnas ordenadas que termina exactamente en la columna 'j'.
        # Inicialmente, cada columna por sí sola es una secuencia de longitud 1.
        dp = [1] * m

        # Recorremos cada columna 'j' de izquierda a derecha
        for j in range(m):
            # Intentamos conectar la columna 'j' con cualquier columna anterior 'k'
            for k in range(j):
                # Para que la columna 'j' pueda ir después de 'k', 
                # strs[i][k] <= strs[i][j] debe cumplirse en TODAS las filas (i).
                # Usamos all() para verificar esto eficientemente.
                if all(strs[i][k] <= strs[i][j] for i in range(n)):
                    # Si es compatible, actualizamos dp[j] con el máximo valor encontrado
                    dp[j] = max(dp[j], dp[k] + 1)
        
        # 'max(dp)' es el número máximo de columnas que podemos mantener.
        # El problema nos pide cuántas borrar, así que restamos el total menos las que dejamos.
        return m - max(dp)
        
# @lc code=end