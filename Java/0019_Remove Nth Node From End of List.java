import java.util.ArrayList;
import java.util.List;

/*
19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
* */
public class Solution0019 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    //自身方法
    public  static ListNode removeNthFromEnd1(ListNode head, int n) {
        List<ListNode> list=new ArrayList<>();
        ListNode tmp=head;
        while (tmp!=null){
            list.add(tmp);
            tmp=tmp.next;
        }

        if(n==1){//删除的是末尾
            if(list.size()==1){
                head=null;
            }else {
                list.get(list.size()-n-1).next=null;
            }
        }else if(n==list.size()){//删除的是开头
            head=list.get(1);
        }else {
            list.get(list.size()-n-1).next=list.get(list.size()-n+1);
        }

        return head;
    }

    //最好方法
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode pre=null;
        ListNode head=null;
        for(int i=1;i<6;i++){
            ListNode item=new ListNode(i);
            if(i==1){
                head=item;
            }
            if(pre!=null){
                pre.next=item;
            }
            pre=item;
        }

        ListNode result=removeNthFromEnd(head,5);

        while (result!=null){
            System.out.print(result.val);
            if(result.next!=null){
                System.out.print("->");
            }
            result=result.next;
        }
        System.out.println();
    }
}
