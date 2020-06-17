import java.util.Scanner;

public class MaxScoreSightseeingPair {
    public static void main(String[] args){
        //5 8 1 5 2 6
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i]=sc.nextInt();
        }
        //------------------------------------------------
        int max = 0;
        int maxScore = nums[0]-1;
        for (int i = 1; i < num; i++) {
            max=Math.max(max,nums[i]+(maxScore));
            maxScore = Math.max(maxScore-1,nums[i]-1);
        }
        System.out.println(max);
    }
}
