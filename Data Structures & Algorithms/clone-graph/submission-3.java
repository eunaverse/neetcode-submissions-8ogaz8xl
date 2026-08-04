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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(node);
        oldToNew.put(node, new Node(node.val));

        while(!que.isEmpty()){
            Node cur = que.poll();
            for(Node ne: cur.neighbors){
                if(!oldToNew.containsKey(ne)){
                    oldToNew.put(ne, new Node(ne.val));
                    que.offer(ne);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(ne));
            }

        }
        return oldToNew.get(node);
    }
}