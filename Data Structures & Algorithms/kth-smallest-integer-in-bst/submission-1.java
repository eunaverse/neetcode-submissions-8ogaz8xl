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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int[] cnt = new int[1];

        return traverse(root, cnt, k).val;

    }

    TreeNode traverse(TreeNode cur, int[] cnt, int k){
        if(cur==null) return cur;

        TreeNode left = traverse(cur.left, cnt, k);
        if(left!=null) return left;
        cnt[0]++;
        if(cnt[0]==k) return cur;
   
        TreeNode right = traverse(cur.right, cnt, k);
        return right;
    }

}
