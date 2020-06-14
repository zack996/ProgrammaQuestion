import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

public class FindBestValue {
    public static void main(String[] args) {
        //11 3 5 9 3
        //56803 5 123345 123123 523422 565621 752342
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++){
            nums[i]=scanner.nextInt();
        }
        //-------------------------------------------------------------
        //int num=nums.length;
        Arrays.sort(nums);
        if(target<nums[0]){
            //return Math.round((float)target/num);
            System.out.println(Math.round((float)target/num));
            return;
        }
        int[] dp = new int[num];
        dp[0]=nums[0]*num;
        for (int i=1;i<num;i++){
            dp[i]=dp[i-1]-nums[i-1]*(num-i)+nums[i]*(num-i);
            if(dp[i-1]<=target&&dp[i]>target){
                int accumulation = dp[i-1]-nums[i-1]*(num-i);
                System.out.println((int)(((float)(target-accumulation)/(num-i))+0.4));//五舍六入
                //return (int)(((float)(target-accumulation)/(num-i))+0.4;
            }
        }

    }
}
