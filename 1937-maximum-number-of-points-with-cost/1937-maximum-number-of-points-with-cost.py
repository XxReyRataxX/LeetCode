class Solution:
    def maxPoints(self, points):
        filas = len(points)
        columnas = len(points[0])
        dp = points[0][:]

        for r in range(1, filas):
            izquierda = [0] * columnas
            derecha = [0] * columnas
            nueva_dp = [0] * columnas

            # Barrido de izquierda a derecha
            izquierda[0] = dp[0]
            for c in range(1, columnas):
                izquierda[c] = max(izquierda[c - 1] - 1, dp[c])

            # Barrido de derecha a izquierda
            derecha[-1] = dp[-1]
            for c in range(columnas - 2, -1, -1):
                derecha[c] = max(derecha[c + 1] - 1, dp[c])

            # Calcular nueva fila de dp
            for c in range(columnas):
                nueva_dp[c] = points[r][c] + max(izquierda[c], derecha[c])

            dp = nueva_dp

        return max(dp)
