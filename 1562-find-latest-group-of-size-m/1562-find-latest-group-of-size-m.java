import java.util.Arrays;

class Solution {
    /**
     * Encuentra el último paso en el que existe un grupo contiguo de unos de longitud exactamente M.
     * * Esta solución optimizada utiliza una complejidad de tiempo O(N) al rastrear dinámicamente 
     * la longitud de los grupos en sus límites y mantener un recuento de grupos de tamaño M.
     * * @param arr El array de permutación que indica el orden de los bits a cambiar a '1'.
     * @param m La longitud requerida del grupo de unos.
     * @return El número del último paso, o -1 si no se encuentra dicho grupo.
     */
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return -1;
        }

        // El array 'length' almacena la longitud del grupo contiguo de '1's 
        // que comienza o termina en el índice dado.
        // Usamos tamaño n + 2 para verificar los límites (índice 0 y n + 1) sin comprobaciones explícitas.
        // length[i] = group_length significa que el grupo que comienza (o termina) en el índice i tiene group_length.
        int[] length = new int[n + 2];
        
        // El array 'count' almacena cuántos grupos de una longitud específica existen.
        // count[l] = número de grupos que actualmente tienen longitud l.
        int[] count = new int[n + 1];

        int latestStep = -1;

        // Iterar a través de cada paso (de 1 a N)
        for (int step = 1; step <= n; step++) {
            // La posición (base 1) en la cadena binaria conceptual que se establecerá a '1'
            int index = arr[step - 1];

            // 1. Determinar las longitudes de los grupos inmediatamente a la izquierda y derecha
            int lenL = length[index - 1]; // Longitud del grupo izquierdo
            int lenR = length[index + 1]; // Longitud del grupo derecho

            // 2. Calcular la nueva longitud total del grupo fusionado
            int newLen = lenL + lenR + 1;

            // 3. Actualización Dinámica del Conteo de Grupos
            
            // Si existía un grupo izquierdo, está a punto de ser destruido. Decrementar su conteo.
            if (lenL > 0) {
                count[lenL]--;
            }
            
            // Si existía un grupo derecho, está a punto de ser destruido. Decrementar su conteo.
            if (lenR > 0) {
                count[lenR]--;
            }
            
            // El nuevo grupo combinado se ha formado. Incrementar su conteo.
            count[newLen]++;

            // 4. Actualizar los Punteros de Límite en el array 'length'
            
            // El nuevo grupo comienza en index - lenL. Actualizar la longitud de su límite.
            length[index - lenL] = newLen;
            
            // El nuevo grupo termina en index + lenR. Actualizar la longitud de su límite.
            length[index + lenR] = newLen;
            
            // La longitud en el índice actual es efectivamente newLen, pero solo 
            // necesitamos actualizar estrictamente los límites exteriores para futuras fusiones.
            
            // 5. Verificar si existe un grupo de tamaño 'm' en este paso
            if (count[m] > 0) {
                latestStep = step;
            }
        }

        return latestStep;
    }
}
