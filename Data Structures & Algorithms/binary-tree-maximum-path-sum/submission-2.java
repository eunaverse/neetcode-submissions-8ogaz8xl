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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      traverse(root);
      return res;
    }

    int traverse(TreeNode cur){
      if(cur==null) return 0;

      int left = Math.max(0, traverse(cur.left));
      int right = Math.max(0, traverse(cur.right));

      res = Math.max(res, left + right + cur.val);
      return Math.max(left, right) + cur.val;

    }
}
