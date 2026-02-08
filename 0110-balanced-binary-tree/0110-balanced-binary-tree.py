#
# @lc app=leetcode id=110 lang=python
#
# [110] Balanced Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self._is_balanced_and_height(root)[0]

    def _is_balanced_and_height(self, node):
        if node is None:
            return True, 0

        left_balanced, left_height = self._is_balanced_and_height(node.left)
        if not left_balanced:
            return False, 0

        right_balanced, right_height = self._is_balanced_and_height(node.right)
        if not right_balanced:
            return False, 0

        balanced = abs(left_height - right_height) <= 1
        height = 1 + max(left_height, right_height)
        return balanced, height


        
# @lc code=end

