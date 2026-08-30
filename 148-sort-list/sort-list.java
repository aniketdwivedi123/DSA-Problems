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

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeSortedList(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }

            curr = curr.next;
        }

        if (p1 != null) {
            curr.next = p1;
        } else {
            curr.next = p2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = mid(head);

        ListNode newHead = middle.next;
        middle.next = null;

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(newHead);

        return mergeSortedList(leftHalf, rightHalf);
    }
}