import java.util.Scanner;

public class ReverseLeftWords {
    //abcdefg 3
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        //------------------------------------------------
        System.out.println(s.substring(n)+s.substring(0,n));
    }
}
