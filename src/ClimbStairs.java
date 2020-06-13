import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        //5
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //---------------------------------------------------------
        int x=0,y=0,z=1;
        for(int i=0;i<n;i++){
            x=y;
            y=z;
            z=x+y;
        }
        System.out.println(z);
    }
}
