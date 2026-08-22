
 class Solution {
    public ListNode insertionSortList(ListNode head) {

        // Dummy node for the sorted list
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {

            // Save next node
            ListNode next = current.next;

            // Find position where current should be inserted
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current
            current.next = prev.next;
            prev.next = current;

            // Move to next unsorted node
            current = next;
        }

        return dummy.next;
    }
}
