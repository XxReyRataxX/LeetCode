/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start


import java.util.HashSet;
import java.util.Set; 

class Solution {
    public boolean containsDuplicate(int[] nums) {
       
        Set<Integer> r = new HashSet<>();

        //O(n), si son diferentes simplemente devolvemos false
        for (int i:nums){
            if (!r.contains(i)){
                r.add(i);
            }else{
                 //apareció dos veces
                
                return true;
              
                
                
            }
        }
        return false;


}
}
// @lc code=end

