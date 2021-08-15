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
//Iteration (Time: O(N) Space: O(1))
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode swap = cur.next.next;
            
            cur.next.next = swap.next;
            swap.next = cur.next;
            cur.next = swap;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}

//Recursion (Time: O(N) Space: O(N))
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;
    }
}