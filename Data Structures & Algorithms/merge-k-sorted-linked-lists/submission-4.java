/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
         public ListNode mergeKLists(ListNode[] lists) {
                  PriorityQueue<ListNode> pq =
                                   new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
                                            for (ListNode node : lists) {
                                                         if (node != null) {
                                                                          pq.add(node);
                                                                                       }
                                                                                                }
                                                                                                         ListNode dummy = new ListNode();
                                                                                                                  ListNode res = dummy;
                                                                                                                           while (!pq.isEmpty()) {
                                                                                                                                        ListNode top = pq.poll();
                                                                                                                                                     dummy.next = top;
                                                                                                                                                                  dummy = dummy.next;
                                                                                                                                                                               if (top.next != null) {
                                                                                                                                                                                                pq.add(top.next);
                                                                                                                                                                                                             }
                                                                                                                                                                                                                      }
                                                                                                                                                                                                                       
                                                                                                                                                                                                                                return res.next;
                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                      }
