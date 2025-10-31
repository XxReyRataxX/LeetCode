/*
 * @lc app=leetcode id=2165 lang=java
 *
 * [2165] Smallest Value of the Rearranged Number
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public long smallestNumber(long num) {
        // Maneja el caso especial del 0
        if (num == 0) {
            return 0;
        }

        // 1. Obtener los dígitos
        long absNum = Math.abs(num);
        String numString = String.valueOf(absNum);
        
        // Usar un array de caracteres es más idiomático para ordenar y manipular
        char[] digits = numString.toCharArray();
        
        // 2. Ordenar los dígitos
        // Esto siempre los ordena de forma ascendente, p.ej., 310 -> ['0', '1', '3']
        Arrays.sort(digits);

        // Variable para construir el resultado final
        long result = 0;

        // Caso 1: Número Positivo (num > 0)
        if (num > 0) {
            
            // Objetivo: El número más pequeño debe tener el dígito no cero más pequeño como primer dígito.

            // 3. Buscar el primer dígito NO CERO
            int firstNonZeroIndex = -1;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != '0') {
                    firstNonZeroIndex = i;
                    break;
                }
            }

            // Si no se encuentra un no cero (solo si el número original fuera 0, ya manejado)
            if (firstNonZeroIndex == -1) {
                return 0; 
            }

            // 4. Intercambiar el primer no cero con el primer dígito (que es un cero, si existe)
            // Ejemplo: ['0', '1', '3'] -> Intercambia '0' y '1' -> ['1', '0', '3']
            char temp = digits[0];
            digits[0] = digits[firstNonZeroIndex];
            digits[firstNonZeroIndex] = temp;
            
            // 5. Reconstruir el número long a partir del array de caracteres
            // (Los ceros ya están colocados correctamente después del primer dígito)
            result = Long.parseLong(new String(digits));
            
        } 
        // Caso 2: Número Negativo (num < 0)
        else {
            
            // Objetivo: Para el negativo más pequeño, necesitamos el valor absoluto más GRANDE.
            // Esto significa que los dígitos deben estar en orden descendente.

            // 3. Invertir el array ordenado (que es ascendente) a descendente
            // Ejemplo: 310 -> ['0', '1', '3'] -> Invertir -> ['3', '1', '0']
            
            // El truco es convertirlo a String, invertirlo y luego convertir a Long, 
            // o simplemente usar un bucle para invertir en el array de caracteres
            // (el enfoque de invertir un char[] es más directo):

            int n = digits.length;
            for (int i = 0; i < n / 2; i++) {
                char temp = digits[i];
                digits[i] = digits[n - 1 - i];
                digits[n - 1 - i] = temp;
            }

            // 4. Reconstruir el número long y aplicar el signo negativo
            result = -Long.parseLong(new String(digits));
        }

        return result;
    }
}
// @lc code=end