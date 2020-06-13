import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    // 6 -1 0 1 2 -1 -4
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++){
            nums[i]=scanner.nextInt();
        }
        //-----------------------------------------------------------
        Arrays.sort(nums);
        for(int i=0;i<num;i++){
            if(i>0&&nums[i]==nums[i-1])i++;
            resolve(nums,i,result);
        }
        System.out.println(result);
    }
    private static void resolve(int[] nums,int index,List<List<Integer>> result){
        int left=index+1;
        int right=nums.length-1;

        while(left<right){
            int sum=nums[index]+nums[left]+nums[right];
            if(sum==0){
                result.add(Arrays.asList(nums[index],nums[left],nums[right]));
                while (left<right && nums[left] == nums[left+1]) left++; // 去重
                while (left<right && nums[right] == nums[right-1]) right--; // 去重
                left++;
                right--;
            }else if(sum<0){
                left++;
            }else if(sum>0){
                right--;
            }

        }
    }
}
