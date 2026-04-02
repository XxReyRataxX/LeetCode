import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int punteroa = 0;
        int maximo = 0;
        
        // Usamos un Set para saber qué caracteres están en nuestra ventana actual
        Set<Character> x = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Si el carácter ya está, movemos el puntero izquierdo y 
            // borramos del Set hasta que la ventana sea válida otra vez
            while (x.contains(currentChar)) {
                x.remove(s.charAt(punteroa));
                punteroa++;
            }

            // Ahora que sabemos que no está repetido, lo añadimos
            x.add(currentChar);

            // Calculamos el tamaño actual: (derecha - izquierda) + 1
            int tamañoVentana = (i - punteroa) + 1;
            if (tamañoVentana > maximo) {
                maximo = tamañoVentana;
            }
        }
        
        return maximo;
    }
}