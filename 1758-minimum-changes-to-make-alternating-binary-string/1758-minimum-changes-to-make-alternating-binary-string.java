/*
 * @lc app=leetcode id=1758 lang=java
 *
 * [1758] Minimum Changes To Make Alternating Binary String
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
    int operacionesInicio0 = 0;
    int operacionesInicio1 = 0;
    char[] r = s.toCharArray();

    for (int i = 0; i < r.length; i++) {
        char esperadoInicio0 = (i % 2 == 0) ? '0' : '1';
        char esperadoInicio1 = (i % 2 == 0) ? '1' : '0';

        if (r[i] != esperadoInicio0) {
            operacionesInicio0++;
        }
        if (r[i] != esperadoInicio1) {
            operacionesInicio1++;
        }
    }

      return Math.min(operacionesInicio0, operacionesInicio1);
    }
  
}
// @lc code=end

