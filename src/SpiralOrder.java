import java.util.Arrays;
import java.util.Scanner;

public class SpiralOrder {
    public static void main(String[] args) {
        //3 3 1 2 3 4 5 6 7 8 9
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int [][] matrix = new int[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        //-----------------------------------------------------
        int t=0;
        int b=y-1;
        int l=0;
        int r=x-1;
        int count=0;
        int [] res=new int[x*y];

        while(true){
            for(int i=l;i<=r;i++)res[count++]=matrix[l][i];
            if(++t>b)break;
            for(int i=t;i<=b;i++) res[count++]=matrix[i][r];
            if(l>--r)break;
            for(int i=r;i>=l;i--)res[count++]=matrix[b][i];
            if(--b<t)break;
            for(int i=b;i>=t;i--)res[count++]=matrix[i][l];
            if(++l>r)break;
        }
        System.out.println(Arrays.toString(res));
    }
}
