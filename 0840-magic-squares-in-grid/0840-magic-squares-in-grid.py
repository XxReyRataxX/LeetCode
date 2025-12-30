class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        cols = len(grid[0])
        count = 0

        # Recorremos la cuadrícula. Para que quepa un 3x3, 
        # nos detenemos 2 posiciones antes del final de filas y columnas.
        for r in range(rows - 2):
            for c in range(cols - 2):
                # Extraemos la subcuadrícula de 3x3 (tu "aux")
                subgrid = [
                    grid[r][c:c+3],
                    grid[r+1][c:c+3],
                    grid[r+2][c:c+3]
                ]
                
                if self.isMagic(subgrid):
                    count += 1
        return count

    def isMagic(self, s):
        # 1. Verificar que los números sean del 1 al 9 sin repetir
        vals = [s[i][j] for i in range(3) for j in range(3)]
        if sorted(vals) != [1, 2, 3, 4, 5, 6, 7, 8, 9]:
            return False
        
        # 2. En un cuadrado mágico de 3x3 con números del 1 al 9, 
        # la suma mágica siempre debe ser 15.
        
        # Filas
        for i in range(3):
            if sum(s[i]) != 15: return False
        
        # Columnas
        for j in range(3):
            if s[0][j] + s[1][j] + s[2][j] != 15: return False
            
        # Diagonales
        if s[0][0] + s[1][1] + s[2][2] != 15: return False
        if s[0][2] + s[1][1] + s[2][0] != 15: return False
        
        return True