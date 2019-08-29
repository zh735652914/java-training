package LeetCode; /**
 * Created by ZhouHao on 2019/4/3.
 */

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;


public class test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = "thisisadogidjasodjaskjdj";
//        String b = "thisisadog skjdj";
//        if(a.isEmpty()&&b.isEmpty()) System.out.println("True");
//        if(a.isEmpty()&&!b.isEmpty()) System.out.println("False");
//        if(isAns(a,b)){
//            System.out.println("True");
//        }
//        else{
//            System.out.println("False");
//        }

        List<String> ans=generateParenthesis(3);
        System.out.println(ans);
        int a=1,b=2,c=3;
        System.out.println("max="+Math.max(4,5));
//        char a='a';
        char z='z';
        char tmp='0';
        System.out.println("a="+(int)a);
        System.out.println("z="+(int)z);
        System.out.println("tmp="+(int)tmp);

//        System.out.println("max="+Math.max(4,5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

//    public static void main(String[] args) {
////        String s1 = "-91283472332";
////        int ans = myAtoi(s1);
////    System.out.println("0="+s1.charAt(p));
////    String ans=convert(s1,n);
//        //System.out.println("ans=" + ans);
////        IO();
////        int [] nums={2,2,1};
////        int ans=singleNumber(nums);
////        System.out.println("ans=" + ans);
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int M= in.nextInt();
//        int f=0;
//        int min=Math.min(M,N);
//        String a="xas";
//        a.substring()
//        System.out.println(min);
//    }

//    private static void IO(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你的姓名：");
//        int name = sc.nextInt();
//        System.out.println("请输入你的年龄：");
//        int age = sc.nextInt();
//        System.out.println("请输入你的工资：");
//       int salary = sc.nextInt();
//        System.out.println("你的信息如下：");
//        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
//    }
//    public static int singleNumber(int[] nums) {
//        int ans=nums[0];
//        for(int i=0;i<nums.length-1;){
//            // ans=nums[i];
//            int j=i+1;
//            for(;j<nums.length;j++){
//                if(ans==nums[j]) break;
//            }
//             if(j==nums.length) break;
//            ans=nums[++i];
//        }
//        // if()
//        return ans;
//    }

}