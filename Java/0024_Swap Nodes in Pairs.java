/*
* 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
* */
public class Solution0024 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode ans=pre;

        while (pre.next!=null&&pre.next.next!=null){
            ListNode first=pre.next;
            ListNode second=pre.next.next;
            first.next=second.next;
            second.next=first;
            pre.next=second;
            pre=pre.next.next;
        }

        return  ans.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);

        ListNode ans=swapPairs(listNode);

        while (ans!=null){
            System.out.print(ans.val);
            if(ans.next!=null){
                System.out.print("->");
            }
            ans=ans.next;
        }
        System.out.println();
    }
}
