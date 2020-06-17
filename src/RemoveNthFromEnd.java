import java.util.Scanner;
import java.util.Stack;

public class RemoveNthFromEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        removeNthFromEnd(head,2);
        System.out.println(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //迭代
/*      Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp!=null){
            stack.push(tmp);
            tmp=tmp.next;
        }

        if(stack.size()==n){
            head=head.next;
        }else{
            ListNode pre = stack.get(stack.size() - n - 1);
            pre.next=pre.next.next;
        }
        return head;*/

        //递归
        if(head.next==null)return null;
        if(recur(head.next,head,2,0,0)==n)return head.next;
        return head;
    }
    public static int recur(ListNode head,ListNode pre,int n,int deep,int now){
        ++now;
        ++deep;
        if(head!=null){
            deep=recur(head.next,head,n,deep,now);
        }

        if(deep-now==n){
            pre.next=pre.next.next;
        }
        return  deep;
    }

}
