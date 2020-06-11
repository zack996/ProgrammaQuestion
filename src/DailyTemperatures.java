import java.util.Arrays;
import java.util.Scanner;

public class DailyTemperatures {
    public static void main(String[] args) {
        //8 73 74 75 71 69 72 76 73
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] T = new int[num];
        for(int i=0;i<num;i++){
            T[i]=sc.nextInt();
        }
        //-------------------------------------------
        int[] result=new int[T.length];
        for(int i=0;i<T.length;i++){
            int day=1;
            for(int j=i+1;j<T.length;j++){
                if(T[i]>=T[j]){
                    day++;
                }else{
                    result[i]=day;
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(result));

    }
}
