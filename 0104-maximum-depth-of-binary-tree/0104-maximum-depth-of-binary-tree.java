/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return calcularDepth(root, 0);
    }

    public int calcularDepth(TreeNode r, int d){
        if (r == null) {
            return d;
        }

        int depthIz = calcularDepth(r.left, d + 1);
        int depthDer = calcularDepth(r.right, d + 1);

        return Math.max(depthIz, depthDer);
    }
}
// @lc code=end

