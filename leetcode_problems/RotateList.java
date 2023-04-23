
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Calculate the length of the list and find the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        
        // Calculate the shift amount and find the new tail node
        int shift = k % length;
        if (shift == 0) {
            return head;
        }
        ListNode newTail = head;
        for (int i = 0; i < length - shift - 1; i++) {
            newTail = newTail.next;
        }
        
        // Rotate the list and return the new head node
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}