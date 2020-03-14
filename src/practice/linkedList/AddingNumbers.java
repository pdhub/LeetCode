package practice.linkedList;

public class AddingNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode ls = new ListNode(0);
        head=ls;
        int carry=0,a=0,sum=0;
        while((l1!=null || l2!=null) || carry==1)
        {
            sum=0;
            if(l1!=null)
            {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            if(carry==1)
            {
                sum = sum + carry;
                carry=0;
            }
            if(sum>9)
            {
                a = sum%10;
                carry = 1;
                ls.next = new ListNode(a);
                ls= ls.next;
            }
            else
            {
                ls.next = new ListNode(sum);
                ls= ls.next;
            }

        }
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
