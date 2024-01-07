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
    public int longestZigZag(TreeNode root) {
        int[] ans = new int[1];
        fun(root, -1, 0, ans);
        return ans[0];
    }

    private void fun(TreeNode root, int dir, int length, int[] ans) {
        if (root == null) {
            return;
        }

        ans[0] = Math.max(ans[0], length);

        if (dir == 0) {
            fun(root.left, 1, length + 1, ans);
            fun(root.right, 0, 1, ans);
        } else {
            fun(root.right, 0, length + 1, ans);
            fun(root.left, 1, 1, ans);
        }
    }
}
