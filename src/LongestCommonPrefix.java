import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {
    //3 flower flow flight
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strs = new String[num];
        for(int i=0;i<num;i++){
            strs[i]=scanner.next();
        }
        //--------------------------------------------
        String result="";
        int at = 0;
        while(true){
            for (int i = 1; i < num; i++) {
                //是否越界
                if(strs[i].length()==at-1||strs[i-1].length()==at-1){
                    System.out.println(strs[i].substring(0,at));
                    return;
                    //return strs[i].substring(0,at);
                }
                if(strs[i].charAt(at)!=strs[i-1].charAt(at)){
                    System.out.println(strs[i].substring(0,at));
                    return;
                    //return strs[i].substring(0,at);
                }
            }
            at++;
        }

    }
}
