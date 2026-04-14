/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ArrayList<Integer> a = new ArrayList<>();
    while (head != null) {
        a.add(head.val);
        head = head.next;
    }

    a.remove(a.size() - n);
    if (a.isEmpty()) {
        return null;
    }

    ListNode r = new ListNode(a.get(0));
    ListNode curr = r;
    for (int i = 1; i < a.size(); i++) {
        curr.next = new ListNode(a.get(i));
        curr = curr.next;
    }
    return r;
    }
}
// @lc code=end

