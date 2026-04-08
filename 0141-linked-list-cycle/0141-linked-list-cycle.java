/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set <ListNode> visitados = new HashSet<>();
        while (head !=null){
            if (visitados.contains(head)){
                return true;
            }else{
                visitados.add(head);
                head= head.next;
            }

        }
        return false;
        
        
    }
}
// @lc code=end

