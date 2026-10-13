import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        // 1. Convertir a long y calcular los cuadrados de cada número
        long[] squares = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        // 2. Ordenar los cuadrados de menor a mayor
        Arrays.sort(squares);

        // 3. Aplicar la alternancia: los más pequeños restan, los más grandes suman.
        // Una forma sencilla tras ordenar de menor a mayor es:
        // Los primeros (la mitad más pequeña) restan, los últimos (la mitad más grande) suman.
        long score = 0;
        int n = squares.length;
        
        for (int i = 0; i < n; i++) {
            // Si el índice está en la primera mitad, resta; si está en la segunda, suma.
            // O siguiendo estrictamente el patrón de índices (par suma, impar resta del array ordenado):
            if (i < (n + 1) / 2) {
                // Los elementos que van en posiciones de suma (pares en orden descendente, o la mitad superior)
                // Vamos a hacerlo explícito con la lógica de restar los más pequeños y sumar el resto:
            }
        }
        
        // Redefiniendo el bucle de forma infalible con los índices ordenados:
        // Si ordenamos de menor a mayor: squares[0], squares[1], ... squares[n-1]
        // Las posiciones del resultado final que restan son los primeros elementos (los más pequeños).
        // Las posiciones que suman son los últimos elementos (los más grandes).
        
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                score -= squares[i]; // Los más pequeños van a las posiciones impares (restan)
            } else {
                score += squares[i]; // Los más grandes van a las posiciones pares (suman)
            }
        }

        return score;
    }
}