import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

record Posicion(int filaOriginal, int ultimoUno) {}

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> maxRight = new ArrayList<>();

        // 1. Extraemos la posición del último 1 de cada fila
        for (int i = 0; i < n; i++) {
            int lastOne = -1;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    lastOne = j;
                }
            }
            maxRight.add(lastOne);
        }

        // 2. Comprobamos si existe solución
        // Copiamos y ordenamos para verificar la viabilidad
        List<Integer> sortedCheck = new ArrayList<>(maxRight);
        Collections.sort(sortedCheck);

        for (int i = 0; i < n; i++) {
            // En la fila i (0-indexed), el último 1 debe estar 
            // en una posición <= i para cumplir la matriz triangular
            if (sortedCheck.get(i) > i) {
                return -1; // No hay solución posible
            }
        }

        // 3. Si existe, calculamos los swaps (Algoritmo Greedy)
        return calcularSwaps(maxRight, n);
    }

    private int calcularSwaps(List<Integer> current, int n) {
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int target = i; // Necesitamos que en la fila i, el último 1 esté en pos <= i
            int rowToMove = -1;

            // Buscamos la primera fila desde i hacia abajo que cumpla la condición
            for (int j = i; j < n; j++) {
                if (current.get(j) <= target) {
                    rowToMove = j;
                    break;
                }
            }

            // Movemos la fila hacia arriba (como un bubble sort local)
            for (int j = rowToMove; j > i; j--) {
                Collections.swap(current, j, j - 1);
                swaps++;
            }
        }
        return swaps;
    }
}