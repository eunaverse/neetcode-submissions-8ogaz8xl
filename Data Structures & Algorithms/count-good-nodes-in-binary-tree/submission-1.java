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
    public int goodNodes(TreeNode root) {
        return dfs(root.val, root);
    }

    int dfs(int maxVal, TreeNode cur){
        if(cur == null) return 0;
        int res = (cur.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, cur.val);
        res += dfs(maxVal, cur.left) + dfs(maxVal, cur.right);

        return res;
    }
}
