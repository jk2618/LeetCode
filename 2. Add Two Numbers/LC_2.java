public class LC_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            // create a new ListNode holding value
            ListNode newNode = new ListNode(value);
            // let the current pointer link to result
            l3.next = newNode;
            // move forward to the next node
            l3 = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(value);
            l3.next = newNode;
            l3 = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int value = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newNode = new ListNode(value);
            l3.next = newNode;
            l3 = newNode;
            l2 = l2.next;
        }
        // when there is a hundred digit after adding up one's and ten's digit, e.g. 93 + 12 = 115
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = newNode;
        }
        return dummy.next;
    }
}
