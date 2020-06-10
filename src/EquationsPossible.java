import java.util.Scanner;


public class EquationsPossible {
    static int[] nums=new int[26];
    public static void main(String[] args) {
        /*
        3
        a==b
        b==c
        a!=c
        */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] equations=new String[num];
        for(int i=0;i<num;i++){
            equations[i]=sc.next();
        }
        //---------------------------------------------
        for(int i=0;i<26;i++){
            nums[i]=i;
        }
        for(int i=0;i<num;i++){
            if(equations[i].charAt(1)=='='){
                union(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
            }
        }
        for(int i=0;i<num;i++){
            if(equations[i].charAt(1)=='!'){
                if(find(equations[i].charAt(0)-'a')==find(equations[i].charAt(3)-'a')) {
                    System.out.println(false);
                    return;
                }
            }
        }


    }

    public static void union(int one,int two){
        nums[find(one)]=find(two);
    }

    public static int find(int index){
        if(nums[index]!=index){
            return find(nums[index]);
        }
        return index;
    }
}
