package node;

  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public static void preOrderTraverse(TreeNode head){
          if(head!=null){
              System.out.println(head.val);
              preOrderTraverse(head.left);
              preOrderTraverse(head.right);
          }
      }
  }