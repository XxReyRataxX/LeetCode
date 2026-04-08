
import java.util.*;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> fusionados = new ArrayList<>();
        if (list1==null && list2==null){
            return list1;
        }
        while (list1 != null){
            fusionados.add(list1.val);
            list1= list1.next;
        }
         while (list2 != null){
            fusionados.add(list2.val);
            list2= list2.next;
        }
        Collections.sort(fusionados);
        ListNode head = new ListNode(fusionados.get(0));
        ListNode tail = head;
        for (int i=1;i<fusionados.size();i++){
            tail.next= new ListNode(fusionados.get(i));
            tail= tail.next;
        }
         return head;
            
        }
       
        
    }

// @lc code=end

