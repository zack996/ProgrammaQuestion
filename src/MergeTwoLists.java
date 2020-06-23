public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        l1=mergeTwoLists(l1,l2);
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
