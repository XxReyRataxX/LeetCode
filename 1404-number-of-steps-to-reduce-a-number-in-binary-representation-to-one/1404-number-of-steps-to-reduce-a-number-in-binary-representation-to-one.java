/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        int pasos = 0;
        int carry = 0;

        // Recorremos de derecha a izquierda hasta el bit más significativo.
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';

            if (bit + carry == 1) {
                // Impar: +1 y luego /2 => 2 pasos
                pasos += 2;
                carry = 1;
            } else {
                // Par: solo /2 => 1 paso
                pasos += 1;
            }
        }

        // Si quedó carry al final, suma un paso extra.
        return pasos + carry;
    }
}
// @lc code=end

