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
//Iterative Reverse ListNode (Time: O(N) Space: O(1))
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevLeft = dummy;
        
        for(int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }
        
        ListNode reversedTail = prevLeft.next;
        ListNode curNode = prevLeft.next;

        ListNode prevNode = null;
        for(int i = 0; i <= right - left; i++) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            
            prevNode = curNode;
            curNode = nextNode;
        }
        prevLeft.next = prevNode;
        reversedTail.next = curNode;
        
        return dummy.next;
    }
}

//Use Stack (Time: O(N) Space: O(N))
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> st = new Stack();
        
        ListNode dummy = new ListNode(-1, head);
        ListNode curNode = dummy;
        
        int i = 1;
        while(i++ < left) {
            curNode = curNode.next;
        }
        
        ListNode prevLeft = curNode;
        i = 0;
        while(i++ <= right - left) {
            curNode = curNode.next;
            st.push(curNode);
        }
        
        ListNode nextRight = curNode.next;
        
        while(!st.isEmpty()) {
            prevLeft.next = st.pop();
            prevLeft = prevLeft.next;
        }
        
        prevLeft.next = nextRight;
        return dummy.next;
    }
}

//Iterative Reverse ListNode by LeetCode (Time: O(N) Space: O(1))
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode prev = null;
        
        while(left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }
        
        ListNode prevLeft = prev;
        ListNode tail = cur;
        
        while(right > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            right--;
        }
        
        if(prevLeft != null)
            prevLeft.next = prev;
        else
            head = prev;
        
        tail.next = cur;
        return head;
    }
}

//Recursive Swapping Values by LeetCode (Time: O(N) Space: O(N))
class Solution {
    ListNode left;
    boolean stop;
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.left = head;
        this.stop = false;
        this.recursiveReverse(head, left, right);
        return head;
    }
    
    private void recursiveReverse(ListNode right, int l, int r) {
        if(r == 1)
            return;
        
        right = right.next;
        
        if(l > 1)
            this.left = this.left.next;
        
        recursiveReverse(right, l - 1, r - 1);
        
        if(left == right || left == right.next)
            stop = true;
        
        if(!stop) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            
            left = left.next;
        }
    }
}