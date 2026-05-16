public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    StringBuilder str = new StringBuilder();

    helper(root, str);
    return str.toString();
  }

  void helper(TreeNode root, StringBuilder stb) {
    if (root == null) {
      stb.append("#,");
      return;
    }
    stb.append(root.val).append(",");
    helper(root.left, stb);
    helper(root.right, stb);
  }


  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    return deHelper(List.of(data.split(",")), new int[1]);
  }

  TreeNode deHelper(List<String> data, int[] idx) {
    if (idx[0] == data.size()) {
      return null;
    }
    String cur = data.get(idx[0]++);
    if (cur.equals("#")) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(cur));
    node.left = deHelper(data, idx);
    node.right = deHelper(data, idx);

    return node;
  }

}
