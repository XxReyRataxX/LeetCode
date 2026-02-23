using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public bool HasAllCodes(string s, int k) {
        // Usamos HashSet en lugar de List para que no haya duplicados
        // Es el equivalente al set() de Python
        HashSet<string> posibles = new HashSet<string>();

        // El bucle 'for' debe ir desde 0 hasta que ya no quepan trozos de tamaÃ±o k
        // Si s mide 10 y k es 2, el Ãºltimo Ã­ndice donde podemos empezar es 8.
        for (int x = 0; x <= s.Length - k; x++) {
            
            // Substring(Ã­ndice_donde_empieza, cuÃ¡ntos_caracteres_toma)
            string trozo = s.Substring(x, k);
            
            // Lo aÃ±adimos al set. Si ya existe, el HashSet lo ignora solo.
            posibles.Add(trozo);
        }

        // Calculamos cuÃ¡ntas combinaciones Ãºnicas existen para k bits: 2 elevado a k
        // Usamos (int)Math.Pow para comparar manzanas con manzanas (enteros)
        int combinacionesTotales = (int)Math.Pow(2, k);

        // Si el tamaÃ±o de nuestro set es igual al total posible, Â¡tenemos todas!
        return posibles.Count == combinacionesTotales;
    }
}