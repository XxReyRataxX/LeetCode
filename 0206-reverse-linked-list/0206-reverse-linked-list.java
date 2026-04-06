/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> values = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        Collections.reverse(values);

        ListNode newHead = new ListNode(values.get(0));
        ListNode tail = newHead;

        for (int i = 1; i < values.size(); i++) {
            tail.next = new ListNode(values.get(i));
            tail = tail.next;
        }

        return newHead;
    }
}
// @lc code=end

