/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
class Solution {
    public int reverseBits(int n) {
         String dato = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
         char[] x = dato.toCharArray();

         int i = 0;
         int j = x.length - 1;
         while (i < j) {
             char temp = x[i];
             x[i] = x[j];
             x[j] = temp;
             i++;
             j--;
         }

         return Integer.parseUnsignedInt(new String(x), 2);
    }
}
// @lc code=end

