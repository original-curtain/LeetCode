import b.k.L;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class AddTwoNums {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode((l1.val+l2.val)%10);
        ListNode point=result;
        int add=(l1.val+l2.val)/10;
        while(l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            point.next=new ListNode((l1.val+l2.val+add)%10);
            add=(l1.val+l2.val+add)/10;
            point=point.next;
        }
        while (l1.next!=null){
            l1=l1.next;
            point.next=new ListNode((l1.val+add)%10);
            add=(l1.val+add)/10;
            point=point.next;
        }
        while (l2.next!=null){
            l2=l2.next;
            point.next=new ListNode((l2.val+add)%10);
            add=(l2.val+add)/10;
            point=point.next;
        }
        if(add!=0){
            point.next=new ListNode(add);
        }
        return  result;
    }

    public static void main(String[] args){
        ListNode l1=new ListNode(3);
        l1.next=new ListNode(7);

        ListNode l2=new ListNode(9);
        l2.next=new ListNode(2);

        ListNode result=addTwoNumbers(l1,l2);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
