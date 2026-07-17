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
    public void reorderList(ListNode head) {
        if(head==null || head.next == null)
            return;

        //get mid and divide list into 2 halves
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast = fast.next.next;
        }
        //reverse the second list
        ListNode second = slow.next;
        slow.next=null;
        ListNode prev= null;
        while(second !=null){
            ListNode nextNodes =second.next;
            second.next=prev;
            prev=second;
            second = nextNodes;
        }
        second = prev; //assign secondList as it is reversed in prev variable
        //merge one by one from 2 lists;
        ListNode first = head;
        while(second!=null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }
}
