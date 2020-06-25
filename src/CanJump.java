import java.util.Scanner;

public class CanJump {
    public static void main(String[] args) {
        //5 2 3 1 1 4
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        //-------------------------------------------------------------
        System.out.println(dfs(0,nums,new boolean[nums.length]));

        

    }
    public static boolean dfs(int index,int[] nums,boolean[] visited){
        if(index==nums.length-1)return true;
        int step = nums[index];
        for (int i = 1; i <= step; i++) {
            if(index+i>nums.length||visited[index+i])continue;
            if(dfs(index+i,nums,visited))return true;
            visited[index+i]=true;
        }
        return false;
    }
}
