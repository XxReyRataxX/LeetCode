class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // m es el número de columnas (ancho), n es el número de filas (alto).
        // En Java, las dimensiones son: matriz[filas][columnas]
        int[][] matriz = new int[m][n]; // Corregido: asumimos matriz[fila][columna] donde fila=m, columna=n

        // Lógica de indexación:
        // El problema indica que m y n representan las dimensiones del grid.
        // Si el problema es de LeetCode 2257, m=filas, n=columnas.
        // Asumiendo matriz[fila][columna], donde la fila va hasta m-1 y columna hasta n-1.
        matriz = new int[m][n]; 

        // 1. Colocar Guardias (1) y Paredes (2)
        // Nota: Asumimos que [0] es la fila e [1] es la columna para mantener 
        // la consistencia con el uso posterior de (i, j) para fila/columna.
        // En tu código original, los índices estaban invertidos.
        for (int[] guard : guards) {
            matriz[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            matriz[wall[0]][wall[1]] = 2;
        }

        // 2. Recorrer la Matriz y "Disparar" la Visibilidad de cada Guardia
        for (int i = 0; i < m; i++) { // i = Fila
            for (int j = 0; j < n; j++) { // j = Columna
                
                // SOLO si encontramos un Guardia (1), calculamos su visibilidad
                if (matriz[i][j] == 1) {
                    
                    // --- REVISIÓN VERTICAL (Columna 'j' fija) ---
                    
                    // 2a. MIRAR HACIA ABAJO (Aumenta la fila 'k')
                    for (int k = i + 1; k < m; k++) { // k: fila
                        int valor = matriz[k][j];
                        if (valor == 1 || valor == 2) {
                            break; // Se detiene si encuentra otra guardia o pared
                        }
                        // Solo marcamos como defendida (3) si NO es una posición 1, 2, o 3
                        if (valor == 0) { 
                            matriz[k][j] = 3; 
                        }
                    }

                    // 2b. MIRAR HACIA ARRIBA (Disminuye la fila 'k')
                    for (int k = i - 1; k >= 0; k--) { // k: fila
                        int valor = matriz[k][j];
                        if (valor == 1 || valor == 2) {
                            break; // Se detiene si encuentra otra guardia o pared
                        }
                        if (valor == 0) { 
                            matriz[k][j] = 3; 
                        }
                    }

                    // --- REVISIÓN HORIZONTAL (Fila 'i' fija) ---

                    // 2c. MIRAR A LA DERECHA (Aumenta la columna 'k')
                    for (int k = j + 1; k < n; k++) { // k: columna
                        int valor = matriz[i][k];
                        if (valor == 1 || valor == 2) {
                            break; // Se detiene si encuentra otra guardia o pared
                        }
                        if (valor == 0) { 
                            matriz[i][k] = 3; 
                        }
                    }

                    // 2d. MIRAR A LA IZQUIERDA (Disminuye la columna 'k')
                    for (int k = j - 1; k >= 0; k--) { // k: columna
                        int valor = matriz[i][k];
                        if (valor == 1 || valor == 2) {
                            break; // Se detiene si encuentra otra guardia o pared
                        }
                        if (valor == 0) { 
                            matriz[i][k] = 3; 
                        }
                    }
                }
            }
        }
        
        // 3. Contar Celdas No Defendidas
        int unGuardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Las celdas NO defendidas son aquellas que quedan con valor 0.
                if (matriz[i][j] == 0) {
                    unGuardedCount++;
                }
            }
        }
        
        return unGuardedCount;
    }
}