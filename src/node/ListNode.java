package node;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void out(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}

