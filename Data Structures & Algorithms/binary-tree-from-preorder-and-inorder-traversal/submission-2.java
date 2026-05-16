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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderIdxMap.put(inorder[i], i);
        }

        int[] preIdx = new int[1];
        return traverse(preorder, inorderIdxMap, preIdx, 0, preorder.length-1);
    }
    TreeNode traverse(int[] preorder, Map<Integer, Integer> inorderIdxMap, int[] preIdx, int left, int right){
        if(preIdx[0] == preorder.length) return null;
        if(left>right) return null;

        int cur = preorder[preIdx[0]++];
        int curInorderIdx = inorderIdxMap.get(cur);
        TreeNode leftNode = traverse(preorder, inorderIdxMap, preIdx, left, curInorderIdx-1);
        TreeNode rightNode = traverse(preorder, inorderIdxMap, preIdx, curInorderIdx+1, right);

        return new TreeNode(cur, leftNode, rightNode);
    }
}
