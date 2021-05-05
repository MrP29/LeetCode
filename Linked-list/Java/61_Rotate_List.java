//Time: O(n) Space: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int size = 1;
        ListNode currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
            size++;
        }
        currNode.next = head;

        for(int i = 0; i < size - k % size; i++) {
            currNode = currNode.next;
        }
        head = currNode.next;
        currNode.next = null;
        
        return head;
    }
}