import node.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode head = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNode.preOrderTraverse(head);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sovle(nums,0,nums.length-1);
    }

    public static TreeNode sovle(int[] nums, int left, int right){
        if(left>right)return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sovle(nums,left,mid-1);
        root.right = sovle(nums,mid+1,right);

        return root;
    }
}
