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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy node is required to handle edge case like
        // [1,2] n=2. so remove 1 from the list. 
        //but without dummy there is "no node before the head"
        //with dummy, slow points to dummy and no loop executes
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i=0;i<=n;i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast=fast.next;
            slow=slow.next; //slow reached a point just before the node to remove
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
