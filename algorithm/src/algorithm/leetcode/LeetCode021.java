package algorithm.leetcode;


public class LeetCode021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr=curr.next;
        }

        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr=curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(-9);
        ListNode l12 = new ListNode(3);
//        ListNode l13 = new ListNode(4);

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(7);
//        ListNode l23 = new ListNode(4);

        l11.next = l12;
//        l12.next = l13;

        l21.next = l22;
//        l22.next = l23;

        ListNode head = mergeTwoLists(l11, l21);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
