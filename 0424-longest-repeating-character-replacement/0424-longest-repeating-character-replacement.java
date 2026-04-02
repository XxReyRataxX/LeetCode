/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            int rightIndex = s.charAt(right) - 'A';
            counts[rightIndex]++;
            if (counts[rightIndex] > maxFrequency) {
                maxFrequency = counts[rightIndex];
            }

            while (right - left + 1 - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
// @lc code=end

