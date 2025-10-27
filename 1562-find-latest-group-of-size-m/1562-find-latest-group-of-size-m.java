/*
 * @lc app=leetcode id=1562 lang=java
 *
 * [1562] Find Latest Group of Size M
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        char[] caracteres;
        int max = 0;
        int step = 1;
        int ultimoPaso = -1;

        Map<Integer, Boolean> map = new HashMap<>();

        // Buscar el máximo para definir el tamaño del array
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // Inicializar array de caracteres con '0'
        caracteres = new char[max];
        for (int i = 0; i < max; i++) caracteres[i] = '0';

        // Simulación paso a paso
        while (step <= n) {
            // Encender el bit correspondiente
            caracteres[arr[step - 1] - 1] = '1';

            int contador1 = 0;
            boolean existeGrupo = false;

            // Contar grupos de 1's de tamaño EXACTO m
            for (int j = 0; j < max; j++) {
                if (caracteres[j] == '1') {
                    contador1++;
                } else {
                    if (contador1 == m) existeGrupo = true;
                    contador1 = 0;
                }
            }
            // Revisar si el último grupo llega al final
            if (contador1 == m) existeGrupo = true;

            map.put(step, existeGrupo);
            step++;
        }

        // Buscar el paso más grande con valor true
        for (int i = n; i >= 1; i--) {
            if (map.get(i) != null && map.get(i)) {
                ultimoPaso = i;
                break;
            }
        }

        return ultimoPaso;
    }
}
