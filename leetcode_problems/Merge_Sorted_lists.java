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
   public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
        return null;
    }
    return mergeLists(lists, 0, lists.length - 1);
}

private ListNode mergeLists(ListNode[] lists, int left, int right) {
    if (left == right) {
        return lists[left];
    }
    int mid = left + (right - left) / 2;
    ListNode leftList = mergeLists(lists, left, mid);
    ListNode rightList = mergeLists(lists, mid + 1, right);
    return mergeTwoLists(leftList, rightList);
}

private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }
    curr.next = (list1 != null) ? list1 : list2;
    return dummy.next;
}

}