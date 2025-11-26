# @lc app=leetcode id=2435 lang=python
#
# [2435] Paths in Matrix Whose Sum Is Divisible by K
#

# @lc code=start
class Solution(object):
    def numberOfPaths(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: int
        """

        M = len(grid)
        N = len(grid[0])
        MOD = 10**9 + 7

        # dp[i][j][r]: Número de caminos de (0,0) a (i,j)
        # cuya suma total tiene un residuo 'r' al dividir por 'k'.
        dp = [[[0 for _ in range(k)] for _ in range(N)] for _ in range(M)]

        ## 1. Caso Base: Celda (0, 0)
        
        # El residuo en la celda inicial es el valor de la celda mod k
        r_inicial = grid[0][0] % k
        dp[0][0][r_inicial] = 1

        ## 2. Llenar la matriz DP

        # Recorremos todas las celdas de la matriz
        for i in range(M):
            for j in range(N):
                # Valor actual de la celda
                v = grid[i][j]
                
                # Para cada posible residuo r' anterior (0 a k-1)
                for r_previo in range(k):
                    
                    # 2.1. Transición desde Arriba (i > 0)
                    if i > 0:
                        # Si llegamos desde (i-1, j) con un residuo r_previo, 
                        # el nuevo residuo r_actual será:
                        r_actual = (r_previo + v) % k
                        
                        # Sumamos los caminos que llegan a (i-1, j) con residuo r_previo
                        dp[i][j][r_actual] = (dp[i][j][r_actual] + dp[i-1][j][r_previo]) % MOD

                    # 2.2. Transición desde Izquierda (j > 0)
                    if j > 0:
                        # Si llegamos desde (i, j-1) con un residuo r_previo, 
                        # el nuevo residuo r_actual será:
                        r_actual = (r_previo + v) % k
                        
                        # Sumamos los caminos que llegan a (i, j-1) con residuo r_previo
                        dp[i][j][r_actual] = (dp[i][j][r_actual] + dp[i][j-1][r_previo]) % MOD

        ## 3. Respuesta Final

        # La respuesta es el número de caminos que llegan a (M-1, N-1) 
        # con un residuo de 0 (lo que significa que la suma es divisible por k).
        return dp[M - 1][N - 1][0]
        
# @lc code=end