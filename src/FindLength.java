import java.util.Scanner;

public class FindLength {
    public static void main(String[] args) {
        //5 1 2 3 4 5 5 1 2 3 2 1
        Scanner scanner = new Scanner(System.in);
        int lenA = scanner.nextInt();
        int[] A = new int[lenA];
        for (int i = 0; i < lenA; i++) {
            A[i] = scanner.nextInt();
        }
        int lenB = scanner.nextInt();
        int[] B = new int[lenB];
        for (int i = 0; i < lenB; i++) {
            B[i] = scanner.nextInt();
        }
        //--------------------------------------------------
        int max = 0;
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max = Math.max(dp[i][j],max);
            }
        }
        System.out.println(max);
    }
}
