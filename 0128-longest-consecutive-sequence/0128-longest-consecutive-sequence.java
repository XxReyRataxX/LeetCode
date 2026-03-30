/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int maximo = 1;
        int sol = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                sol++;
            } else {
                 if (sol > maximo) {
                    maximo = sol;
                 }
                 sol = 1;
            }
        }

        return Math.max(maximo, sol);
    }
}
// @lc code=end

