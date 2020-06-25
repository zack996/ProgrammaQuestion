import java.util.*;

public class WordBreak {
    //类似55. 跳跃游戏
    public static void main(String[] args) {
        //cars 3 car ca rs
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int num = scanner.nextInt();
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            wordDict.add(scanner.next());
        }
        //-----------------------------------------------------
        System.out.println(solve(0,wordDict,s,new boolean[s.length()+1]));
    }

    public static boolean solve(int index,List<String> wordDict,String s,boolean[] visited){
        if(index==s.length())return true;
        for (String next:wordDict){
            int nextLen = next.length()+index;
            //利用visited进行剪枝,true表示s前nextLen个字符已成功被字典组合,不必再计算,跟dp很像
            if(nextLen>s.length()||visited[nextLen])continue;
            if(s.startsWith(next, index)){
                if (solve(nextLen,wordDict,s,visited))return true;
                visited[nextLen]=true;
            }
        }
        return false;
    }
}
