import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        //-----------------------------------------------------
        StringBuilder s = new StringBuilder();
        int carry=0,index1 = a.length()-1,index2 = b.length()-1;
        while(index1>=0||index2>=0||carry==1){
            carry+=index1>=0?a.charAt(index1--)-'0':0;
            carry+=index2>=0?b.charAt(index2--)-'0':0;
            s.append((carry&1)+"");
            carry>>=1;
        }
        System.out.println(s.reverse());
    }
}
