import java.util.Arrays;
import java.util.Scanner;

/*笔记
* 做深度搜索或递归时 不要一直深挖 不然会把自己绕晕
* 只思考第一层和最后一层 思考如何选择 最后一层什么条件成立
*
*
* */
public class PatternMatching {
    //abba dogcatcatdog
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.next();
        String value = scanner.next();
        //--------------------------------------
        String[] strings = new String[2];
        System.out.println(solve(strings,0,pattern,0,value));
    }

    public static boolean solve(String[] s,int patternIndex,String pattern,int valueIndex,String value){
        //最后一层 成立条件
        if(patternIndex==pattern.length()&&valueIndex==value.length())return true;
        //越界条件
        if(patternIndex>=pattern.length()||valueIndex>value.length())return false;
        //算出下标
        int n=pattern.charAt(patternIndex)-'a';
        if(s[n]==null){
            //从当前尝试a||b对应的字符串的每一种可能
            for (int i = valueIndex; i <= value.length(); i++) {
                s[n]=value.substring(valueIndex,i);
                if(!s[n].equals(s[n^1])&&solve(s,patternIndex+1,pattern,i,value)){
                    return true;
                }
            }
            //不符合条件 回溯
            s[n]=null;
            return false;
        }else{
            //表示 a||b 已被确定,截取a||b的长度 判断是否和a||b相同
            int end = valueIndex+s[n].length();
            if(end>value.length()||!value.substring(valueIndex,end).equals(s[n]))return false;
            return solve(s,patternIndex+1,pattern,end,value);
        }

    }

}
