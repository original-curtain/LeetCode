import java.util.ArrayList;
import java.util.List;

/*
23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
* */
public class Solution0023 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //最优方法 采用优先队列进行自动排序
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;

        List<Integer> notNullP=new ArrayList<>();

        ListNode[] p = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            p[i] = lists[i];
            if(p[i]!=null){
                notNullP.add(i);
            }
        }

        while (notNullP.size()!=0) {

            int target = notNullP.get(0);
            for(int i=1;i<notNullP.size();i++){
                if(p[notNullP.get(i)].val<p[target].val){
                    target=notNullP.get(i);
                }
            }

            tmp.next = p[target];
            tmp = tmp.next;
            p[target] = p[target].next;
            if(p[target]==null){
                notNullP.remove(new Integer(target));
            }
        }

        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(1);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(2);

        ListNode l3=new ListNode(1);

        ListNode[] listNodes=new ListNode[]{l1,l2,l3};
        ListNode ans=mergeKLists(listNodes);

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
