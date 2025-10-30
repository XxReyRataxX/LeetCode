/*
 * @lc app=leetcode id=1526 lang=java
 *
 * [1526] Minimum Number of Increments on Subarrays to Form a Target Array
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public int minNumberOperations(int[] target) {
        if (target == null || target.length == 0) return 0;

        int n = target.length;
        int[] curr = new int[n]; // empieza en ceros
        int ops = 0;

        // Siga la lógica: en cada operación buscamos segmentos contiguos
        // donde curr[i] < target[i] y añadimos +1 a todo el segmento.
        while (!Arrays.equals(curr, target)) {
            int i = 0;
            while (i < n) {
                if (curr[i] < target[i]) {
                    // iniciar segmento en i
                    int j = i;
                    while (j + 1 < n && curr[j + 1] < target[j + 1]) {
                        j++;
                    }
                    // incrementar todo el segmento [i..j] en 1
                    for (int k = i; k <= j; k++) {
                        curr[k]++;
                    }
                    ops++;
                    // continuar desde j+1
                    i = j + 1;
                } else {
                    i++;
                }
            }
        }

        return ops;
    }
}

// @lc code=end

