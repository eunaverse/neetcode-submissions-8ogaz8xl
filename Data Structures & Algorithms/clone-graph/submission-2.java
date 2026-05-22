/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {

  Map<Node, Node> oldToNewMap = new HashMap<>();

  public Node cloneGraph(Node node) {
    bfs(node);
    return oldToNewMap.get(node);
  }

  void bfs(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> que = new LinkedList<>();
    que.add(node);
    oldToNewMap.put(node, new Node(node.val));

    while (!que.isEmpty()) {
      Node cur = que.poll();
      Node newNode = oldToNewMap.get(cur);

      for (Node nei : cur.neighbors) {
        if (!oldToNewMap.containsKey(nei)) {
          oldToNewMap.put(nei, new Node(nei.val));
          que.add(nei);
        }
        newNode.neighbors.add(oldToNewMap.get(nei));
      }

    }

  }
}