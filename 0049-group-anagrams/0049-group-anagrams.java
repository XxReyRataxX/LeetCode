/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String [] ordenado = new String[strs.length];
        List<List<String>> sol = new ArrayList<>();
        boolean [] usado = new boolean[strs.length];
        char [] aux;
        String s;
        boolean notiene=false;

        for (int i=0;i<strs.length;i++){
            aux = strs[i].toCharArray();
            Arrays.sort(aux);
            s= new String(aux);
            ordenado[i] = s;
        }

        for (int i = 0; i < ordenado.length; i++) {
            if (usado[i]) continue;   // ya está en otro grupo

            ArrayList<String> aux1 = new ArrayList<>();
            aux1.add(strs[i]);
            usado[i] = true;

            for (int j = i + 1; j < ordenado.length; j++) {
                if (!usado[j] && ordenado[i].equals(ordenado[j])) {
                    aux1.add(strs[j]);
                    usado[j] = true;
                }
            }

            sol.add(aux1);
        }

        return sol;
    }
}
// @lc code=end

