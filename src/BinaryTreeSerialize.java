import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class BinaryTreeSerialize {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode head = new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
        head.right.left=new TreeNode(4);
        head.right.right=new TreeNode(5);
        System.out.println(codec.serialize(head));
        codec.deserialize(codec.serialize(head));
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)return "";
            ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
            treeNodes.add(root);
            list.add(root.val);

            while(!treeNodes.isEmpty()){
                for (int i = 0; i < treeNodes.size(); i++) {
                    TreeNode pop = treeNodes.pop();
                    if(pop.left!=null)
                    treeNodes.add(pop.left);
                    if(pop.right!=null)
                    treeNodes.add(pop.right);
                    if(pop.left==null){
                        list.add(null);
                    }else{
                        list.add(pop.left.val);
                    }
                    if(pop.right==null){
                        list.add(null);
                    }else{
                        list.add(pop.right.val);
                    }
                }
            }
            return Arrays.toString(list.toArray());
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals(""))return null;
            data=data.substring(1,data.length()-1);
            String[] split = data.split(", ");
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            TreeNode result = new TreeNode(Integer.parseInt(split[0]));
            queue.add(result);
            int i=0;
            while(!queue.isEmpty()){
                TreeNode head=queue.pop();
                if(!split[++i].equals("null")){
                    head.left=new TreeNode(Integer.parseInt(split[i]));
                    queue.add(head.left);
                }
                if(!split[++i].equals("null")){
                    head.right=new TreeNode(Integer.parseInt(split[i]));
                    queue.add(head.right);
                }
            }
            return result;
        }

    }

}
