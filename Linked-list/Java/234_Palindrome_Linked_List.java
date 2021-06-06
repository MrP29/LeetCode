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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        ListNode prev = null;
        while(fast != null) {
            ListNode temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }

        ListNode left = head;
        ListNode right = prev;
        while(right != null) {
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        fast = slow.next;
        while(fast != null) {
            ListNode temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }

        return true;
    }
}

//Time: O(n) Space: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        while(curNode != null) {
            size++;
            curNode = curNode.next;
        }
        if(size == 0 || size == 1)
            return true;
        
        curNode = head;
        ListNode newHead = null;
        //Reverse first half
        for(int i = 0; i < size / 2 - 1; i++) {
            newHead = curNode.next;
            curNode.next = curNode.next.next;
            newHead.next = head;
            head = newHead;
        }
        
        curNode = size % 2 == 0 ? curNode.next : curNode.next.next;
        //Compare reversed first half and second half
        while(curNode != null) {
            if(head.val != curNode.val)
                return false;
            head = head.next;
            curNode = curNode.next;
        }
        return true;
    }
}

//Array(Time: O(n) Space: O(n))
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curNode = head;
        while(curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }
        
        int i = 0;
        int j = list.size() - 1;
        while(i < j) {
            if(list.get(i++) != list.get(j--))
                return false;
        }
        return true;
    }
}
