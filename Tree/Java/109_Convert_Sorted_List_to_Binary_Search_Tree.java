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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Recursion with ArrayList (Time: O(N) Space: O(N))
class Solution {
    List<Integer> list;
    
    public TreeNode sortedListToBST(ListNode head) {
        list = new ArrayList();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        return listToBST(0, list.size() - 1);
    }
    
    private TreeNode listToBST(int left, int right) {
        if(left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        
        if(left == right)
            return node;
        
        node.left = listToBST(left, mid - 1);
        node.right = listToBST(mid + 1, right);
        return node;
    }
}

//Recursion (Time: O(NlogN) Space: O(logN))
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        
        ListNode mid = search(head);
        
        TreeNode node = new TreeNode(mid.val);
        
        if(head == mid)
            return node;
        
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }
    
    private ListNode search(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        if(prevPtr != null)
            prevPtr.next = null;
        
        return slowPtr;
    }
}

//Inorder Simulation by LeetCode (Time: O(N) Space: O(logN))
class Solution {
    ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        
        ListNode curNode = head;
        while(curNode != null) {
            size++;
            curNode = curNode.next;
        }
        
        this.head = head;
        
        return listToBST(0, size - 1);
    }
    
    private TreeNode listToBST(int left, int right) {
        if(left > right)
            return null;
        
        int mid = (left + right) / 2;
        
        TreeNode leftNode = listToBST(left, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = leftNode;
        
        this.head = this.head.next;
        
        node.right = listToBST(mid + 1, right);
        return node;
    }
}