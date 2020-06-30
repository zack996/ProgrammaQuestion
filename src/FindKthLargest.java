import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargest {
    public static void main(String[] args) {
        //5 5 8 2 1 3 2
        //2 2 1 2
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=scanner.nextInt();
        }
        int k = scanner.nextInt();
        //---------------------------------------------------
        //小顶堆
        PriorityQueue<Integer> integers = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if(i<k){
                integers.add(nums[i]);
            }else if(integers.peek()<nums[i]){
                integers.poll();
                integers.add(nums[i]);
            }
        }
        System.out.println(integers.poll());

        //堆排
        for (int i = nums.length/2-1; i >= 0; i--) {
            adjustHeap(nums,i,nums.length);
        }
        //正常的堆排 i>0是因为最后一个数不需要排列 但现在只排序k个 所以需要大于等于
        for(int i = nums.length-1;i >= nums.length-k ;i--){
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(nums[nums.length-k]);
    }

    public static void adjustHeap(int[] nums,int node,int tail){
        int left = node*2+1;
        int right = node*2+2;

        int max = node;
        if(left<tail&&nums[left]>nums[max]){
            max=left;
        }
        if(right<tail&&nums[right]>nums[max]){
            max=right;
        }

        if(max!=node){
            swap(nums,max,node);
            adjustHeap(nums,max,tail);
        }
    }

    public static void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=tmp;
    }

}
