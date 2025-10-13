import java.util.*;

class Solution {
    public int countWays(List<Integer> nums) {
        // Ordenamos los valores
        Collections.sort(nums);
        int n = nums.size();
        int ways = 0;

        // Caso 1: seleccionar a 0 estudiantes
        if (0 < nums.get(0)) ways++;

        // Caso 2: probar seleccionar k estudiantes (1..n-1)
        for (int k = 1; k < n; k++) {
            if (nums.get(k - 1) < k && k < nums.get(k)) {
                ways++;
            }
        }

        // Caso 3: seleccionar a todos los estudiantes
        if (nums.get(n - 1) < n) ways++;

        return ways;
    }
}
