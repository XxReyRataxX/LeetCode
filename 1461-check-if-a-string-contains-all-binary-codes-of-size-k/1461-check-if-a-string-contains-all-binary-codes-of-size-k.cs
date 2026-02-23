using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public bool HasAllCodes(string s, int k) {
        // Usamos HashSet en lugar de List para que no haya duplicados
        // Es el equivalente al set() de Python
        HashSet<string> posibles = new HashSet<string>();

        // El bucle 'for' debe ir desde 0 hasta que ya no quepan trozos de tamaño k
        // Si s mide 10 y k es 2, el último índice donde podemos empezar es 8.
        for (int x = 0; x <= s.Length - k; x++) {
            
            // Substring(índice_donde_empieza, cuántos_caracteres_toma)
            string trozo = s.Substring(x, k);
            
            // Lo añadimos al set. Si ya existe, el HashSet lo ignora solo.
            posibles.Add(trozo);
        }

        // Calculamos cuántas combinaciones únicas existen para k bits: 2 elevado a k
        // Usamos (int)Math.Pow para comparar manzanas con manzanas (enteros)
        int combinacionesTotales = (int)Math.Pow(2, k);

        // Si el tamaño de nuestro set es igual al total posible, ¡tenemos todas!
        return posibles.Count == combinacionesTotales;
    }
}