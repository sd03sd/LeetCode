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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newRoot = null;
        if(depth == 1){
            newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, 1, depth, val);
        return root;
    }

    public TreeNode dfs(TreeNode root, int currDepth, int depth, int val){
        if(root == null){
            return root;
        }
        if(currDepth == (depth-1)){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
            return root;
        }
        dfs(root.left, currDepth+1, depth, val);
        dfs(root.right, currDepth+1, depth, val);
        return root;
    }
}