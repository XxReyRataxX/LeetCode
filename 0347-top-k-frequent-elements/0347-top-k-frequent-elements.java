/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> x = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!x.containsKey(nums[i])){
                x.put(nums[i],1);
            }else{
                int r = x.get(nums[i]);
                x.remove(nums[i]);
                r+=1;
                x.put(nums[i],r);
            }
        }

        List<Map.Entry<Integer, Integer>> lista = new ArrayList<>();
        lista.addAll(x.entrySet());
        lista.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] sol = new int[k];
        for (int i = 0; i < k; i++) {
            sol[i] = lista.get(i).getKey();
        }

        return sol;
        
    }
}
// @lc code=end

