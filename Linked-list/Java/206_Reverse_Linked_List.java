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

//Iteration(Time: O(n) Space: O(1))
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curNode = head;
        ListNode newHead = null;
        while(curNode.next != null) {
            newHead = curNode.next;
            curNode.next = curNode.next.next;
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
}

//Recursive(Time: O(n) Space: O(n))
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

//Array(Time: O(n) Space: O(n))
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        List<ListNode> nodes = new ArrayList<>();
        
        ListNode curNode = head;
        while(curNode != null) {
            nodes.add(curNode);
            curNode = curNode.next;
        }
        
        for(int i = nodes.size() - 1; i > 0; i--) {
            nodes.get(i).next = nodes.get(i - 1);
        }
        nodes.get(0).next = null;
        return nodes.get(nodes.size() - 1);
    }
}
