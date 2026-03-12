/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> m = new HashMap<>();
         Map<Character,Integer> r = new HashMap<>();
        for (int i=0;i<s.length();i++){
             char c= s.charAt(i);
            if (m.containsKey(c)){
                
                int x = m.get((Object) c);
                m.remove(c);
                x+=1;
                m.put(c,x);


            }else{
                m.put(c,1);
            }
        }
          for (int i=0;i<t.length();i++){
            char c= t.charAt(i);
            if (r.containsKey(c)){
                
                int x = r.get((Object) c);
                r.remove(c);
                x+=1;
                r.put(c,x);


            }else{
                r.put(c,1);
            }
        }
        return m.equals(r);
       
}
}
// @lc code=end

