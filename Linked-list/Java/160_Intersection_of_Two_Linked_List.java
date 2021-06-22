/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Two Pointer (Time: O(Max(n, m)) Space: O(1))
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        
        while(curA != null) {
            curA = curA.next;
            headA = headA.next;
        }
        
        while(curB != null) {
            curB = curB.next;
            headB = headB.next;
        }
        
        while(headA != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

//Two Pointer (Time: O(n + m) Space: O(1))
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while(node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }
}

//Hash Table (Time: O(Max(n, m)) Space: O(n))
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
