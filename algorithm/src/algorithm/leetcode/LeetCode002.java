package algorithm.leetcode;

public class LeetCode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2+carry;
            boolean check = false;

            if (sum >= 10) {
                sum -= 10;
                check = true;
            }

            curr.next = new ListNode(sum );
            curr = curr.next;

            if (check) carry = 1;
            else carry = 0;

            if(l1!=null) l1= l1.next;
            if(l2!=null) l2= l2.next;
        }

        if(carry == 1)
            curr.next = new ListNode(1);


        return head.next;
    }


    public static void main(String[] args) {
        LeetCode002 test = new LeetCode002();
        ListNode l1 = new ListNode(1);
//        l1.setNext(new ListNode(4));
//        l1.getNext().setNext(new ListNode(3));
        ListNode l2 = new ListNode(9);
        l2.setNext(new ListNode(9));
//        l2.getNext().setNext(new ListNode(4));

        l1 = test.addTwoNumbers(l1, l2);
        while (l1 != null) {
            System.out.println(l1.getVal());
            l1 = l1.getNext();
        }
    }
}

class ListNode {
    int val;
    ListNode next;


    ListNode(int x) {
        val = x;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

}