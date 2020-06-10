import java.util.Scanner;

public class TranslateNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        //----------------------------------------------
        String numStr = String.valueOf(num);
        int[] dp =new int[numStr.length()];

        dp[0]=1;
        int n = Integer.parseInt(numStr.substring(0,2));
        dp[1] = n > 9 && n < 26 ? 2 : 1;

        for(int i=2;i<numStr.length();i++){
            n=Integer.parseInt(numStr.substring(i-1,i+1));
            if(n>9&&n<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        System.out.println(dp[numStr.length()-1]);
    }
}
