import node.ListNode;

public class GetKthFromEnd {
    public static void main(String[] args){
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode.out(getKthFromEnd(head,2));
        ListNode.out(recursion(head,2));
    }
    //迭代
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            tail=tail.next;
        }
        while (tail!=null){
            head=head.next;
            tail=tail.next;
        }

        return head;
    }
    //递归
    static int tail = 0;

    public static ListNode recursion(ListNode head, int k){
        if(head==null){
            return null;
        }
        ListNode tmp=recursion(head.next,k);
        tail++;
        if(tail==k){
            return head;
        }
        return tmp;
    }
}
