package practice.linkedList;

public class AddingNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            carry = temp / 10;
            temp = temp % 10;
            result.next = new ListNode(temp);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int temp = l1.val + carry;
            carry = temp / 10;
            temp = temp % 10;
            result.next = new ListNode(temp);
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int temp = l2.val + carry;
            carry = temp / 10;
            temp = temp % 10;
            result.next = new ListNode(temp);
            result = result.next;
            l2 = l2.next;
        }

        if (carry != 0)
            result.next = new ListNode(carry);
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(9 / 10);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
