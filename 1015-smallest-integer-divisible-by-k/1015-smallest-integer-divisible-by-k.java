/*
 * @lc app=leetcode id=1015 lang=java
 *
 * [1015] Smallest Integer Divisible by K
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        int resto = 1 % k;
        int longitud = 1;

        if ((k % 2)==0) return -1;
        if ((k%5)==0) return -1;

        while (resto != 0) {
        resto = (resto * 10 + 1) % k;
        longitud += 1;
        }
        
        
        return longitud;

    }
}
// @lc code=end

