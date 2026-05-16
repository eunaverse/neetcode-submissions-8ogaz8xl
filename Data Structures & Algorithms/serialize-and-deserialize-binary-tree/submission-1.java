public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    StringBuilder str = new StringBuilder();
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
      TreeNode node = que.poll();
      if (node == null) {
        str.append("#");
      } else {
        str.append(node.val);
        que.add(node.left);
        que.add(node.right);
      }

      str.append(",");
    }

    return str.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int idx = 0;
    List<String> encoded = List.of(data.split(","));
    Queue<TreeNode> queue = new LinkedList<>();
    String val = encoded.get(idx++);
    TreeNode root = null;
    if (val.equals("#")) {
      return root;
    }
    root = new TreeNode(Integer.parseInt(val));
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (idx < encoded.size()) {
        String left = encoded.get(idx++);
        if (!left.equals("#")) {
          cur.left = new TreeNode(Integer.parseInt(left));
          queue.add(cur.left);
        }
      }

      if (idx < encoded.size()) {
        String right = encoded.get(idx++);
        if (!right.equals("#")) {
          cur.right = new TreeNode(Integer.parseInt(right));
          queue.add(cur.right);
        }
      }
    }

    return root;

  }

}