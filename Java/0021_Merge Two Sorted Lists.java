/*
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
* */
public class Solution0021 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode cur=null;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                if(cur==null) {
                    result=cur=l1;
                    l1=l1.next;
                }else {
                    cur.next=l1;
                    cur=cur.next;
                    l1=l1.next;
                }
            }else {
                if(cur==null) {
                    result=cur=l2;
                    l2=l2.next;
                }else {
                    cur.next=l2;
                    cur=cur.next;
                    l2=l2.next;
                }
            }
        }

        if(l1!=null) {
            if(result==null){
                result=l1;
            }else {
                cur.next=l1;
            }
        }
        if(l2!=null){
            if(result==null){
                result=l2;
            }else {
                cur.next=l2;
            }
        }

        return result;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(5);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(3);

        ListNode result=mergeTwoLists(l1,l2);
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
