import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        // 1. Primero ordenamos el array numéricamente (para el desempate)
        Arrays.sort(arr);
        
        int[] resultado = new int[arr.length];
        // Tu Mapa: Guardamos el índice del número en el array ordenado y su cantidad de 1s
        Map<Integer, Integer> datos = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Usamos tu lógica de String para contar unos
            String aux = Integer.toBinaryString(arr[i]);
            int contador = 0;

            for (int j = 0; j < aux.length(); j++) { // Usamos 'j' para no chocar con el 'i' de fuera
                if (aux.charAt(j) == '1') {
                    contador++;
                }
            }
            // En el mapa: clave = posición en array, valor = cuántos unos tiene
            datos.put(i, contador);
        }

        // 2. Ahora rellenamos el 'resultado' basándonos en el mapping
        int indiceResultado = 0;
        
        // Recorremos desde 0 hasta 32 bits (el máximo posible)
        for (int numUnos = 0; numUnos <= 32; numUnos++) {
            for (int i = 0; i < arr.length; i++) {
                // Si el número en la posición 'i' tiene la cantidad de unos que buscamos ahora
                if (datos.get(i) == numUnos) {
                    resultado[indiceResultado] = arr[i];
                    indiceResultado++;
                }
            }
        }
        
        return resultado;
    }
}