
//  public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
 

class Solution {
    int preIdx = 0;
    int[] ind = new int[2001];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        for(int i: inorder){
            ind[i+1000] = idx++;
        }
       return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l,int r){
        if (l > r) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int inIdx = ind[rootVal+1000];
        root.left = dfs(preorder, l, inIdx-1);
        root.right = dfs(preorder, inIdx+1,r);

        return root;
    }
}
