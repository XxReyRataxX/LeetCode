/*
 * @lc app=leetcode id=2125 lang=java
 *
 * [2125] Number of Laser Beams in a Bank
 */

// @lc code=start
class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        if (m == 0) return 0;
        int n = bank[0].length();

        int laser = 0;
        int prevCount = 0; // número de dispositivos en la última fila no vacía

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int c = 0; c < n; c++) if (bank[i].charAt(c) == '1') cnt++;
            if (cnt == 0) continue;          // fila vacía -> ignorar
            if (prevCount > 0) {
                laser += prevCount * cnt;   // sumar haces entre la fila previa no vacía y la actual
            }
            prevCount = cnt;                // actualizar la fila previa no vacía
        }

        return laser;
    }
}
// @lc code=end

