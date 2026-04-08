/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ArrayList<Integer> values = new ArrayList<>();
        ListNode aux = head;
        while (aux != null) {
            values.add(aux.val);
            aux = aux.next;
        }

        int left = 0;
        int right = values.size() - 1;
        ListNode current = head;

        while (current != null) {
            current.val = values.get(left++);
            current = current.next;

            if (current == null) {
                break;
            }

            current.val = values.get(right--);
            current = current.next;
        }
    }
}
// @lc code=end

