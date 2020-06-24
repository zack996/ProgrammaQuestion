import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    public static void main(String[] args) {
        // 1 4 -1 2 1 -4
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int num = scanner.nextInt();
        int nums[] = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i]=scanner.nextInt();
        }
        //--------------------------------------------------
        //双指针解法
        Arrays.sort(nums);
        int best = 100000;
        for (int i = 0; i < num; i++) {
            int left = i+1;
            int right = num-1;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }

                if(sum==target){
                    System.out.println(sum);
                    return;
                }

                if(sum>target){
                    while(left<right&&nums[right]==nums[right-1])right--;
                    right--;
                }else{
                    while(left<right&&nums[left]==nums[left+1])left++;
                    left++;
                }
            }
        }
        System.out.println(best);
    }

}
