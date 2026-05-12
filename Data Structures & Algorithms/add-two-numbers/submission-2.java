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
       public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummy = new ListNode(0);
                         ListNode res = dummy;
                                  int carry = 0;
                                           while (l1 != null || l2 != null) {
                                                        int val = carry;
                                                                     if (l1 != null) {
                                                                                      val += l1.val;
                                                                                                       l1 = l1.next;
                                                                                                                    }
                                                                                                                                 if (l2 != null) {
                                                                                                                                                  val += l2.val;
                                                                                                                                                                   l2 = l2.next;
                                                                                                                                                                                }
                                                                                                                                                                                             carry = val / 10;
                                                                                                                                                                                                          dummy.next = new ListNode(val % 10);
                                                                                                                                                                                                                       dummy = dummy.next;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                          if (carry > 0) {
                                                                                                                                                                                                                                                       dummy.next = new ListNode(carry);
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                          return res.next;
                                                                                                                                                                                                                                                                               }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                
