import node.ListNode;

public class MergeKLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = {l1,l2,l3};
        ListNode node = mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        int len = lists.length;

        //分治法
        while (len>1){
            for(int i=0;i<len/2;i++){
                lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                result.next=l1;
                l1=l1.next;
            }else {
                result.next=l2;
                l2=l2.next;
            }
            result=result.next;
        }
        result.next=l1==null?l2:l1;
        return head.next;
    }
}
