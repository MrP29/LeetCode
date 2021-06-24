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
//Time: O(n) Space: O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode oddTail = head;        
        ListNode evenTail = head.next;
        ListNode cur = head.next;
        
        while(cur != null && cur.next != null) {
            cur = cur.next;
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
            cur.next = oddTail.next;
            oddTail.next = cur;
            oddTail = oddTail.next;
            cur = evenTail;
        }
        return head;
    }
}

//Time: O(n) Space: O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}