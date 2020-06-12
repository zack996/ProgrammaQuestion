import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        //9 4 2 7 11 15
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++){
            nums[i]=scanner.nextInt();
        }
        //--------------------------------------------------
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num;i++){
            int result=target-nums[i];
            if(map.containsKey(result)){
                System.out.println(Arrays.toString(new int[]{i,map.get(result)}));
                return;
            }
            map.put(nums[i],i);
        }
    }
}
