package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/11/17 12:37
 * 给定一个字符串数组,求该数组的连续非空子集，分別打印出来各子集
 */
public class Mayi {
    public List<String> subsets(String str) {
        List<String> ans = new ArrayList<>();
        ans.add("");
        int len = str.length();
        for (int i = 0; i < len; i++) {
            List<String> nextSubSet = new ArrayList<>();
            for (String subSet : ans) {
                String tmp = subSet + str.charAt(i);
                if (tmp.length() > 1) {
                    System.out.println(tmp);
                    tmp.substring(1);
                    System.out.println("111" + tmp);
                }
                nextSubSet.add(tmp);
            }
            ans.addAll(nextSubSet);
        }
        ans.remove("");
        return ans;
    }

    public static void main(String[] args) {
        String string = "abc";
        System.out.println(new Mayi().subsets(string));
    }
}
