/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

 class Solution {
         public Node copyRandomList(Node head) {
                  Map<Node, Node> oldToNewNodeMap = new HashMap<>();
                           Node dummy = head;
                                    while (dummy != null) {
                                                 oldToNewNodeMap.put(dummy, new Node(dummy.val));
                                                              dummy = dummy.next;
                                                                       }
                                                                        
                                                                                 dummy = head;
                                                                                          while (dummy != null) {
                                                                                                       Node newNode = oldToNewNodeMap.get(dummy);
                                                                                                                   newNode.next = oldToNewNodeMap.get(dummy.next);
                                                                                                                                 newNode.random = oldToNewNodeMap.get(dummy.random);
                                                                                                                                             dummy = dummy.next;
                                                                                                                                                       }
                                                                                                                                                        
                                                                                                                                                                 return oldToNewNodeMap.get(head);
                                                                                                                                                                      }
                                                                                                                                                                       }

 
