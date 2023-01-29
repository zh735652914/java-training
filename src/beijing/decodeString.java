package beijing;
/*
https://leetcode-cn.com/problems/decode-string/
 */

import java.util.Stack;

public class decodeString {
    // 自己没写出来，得好好看看
    static class Solution {
        public String decodeString(String s) {
            StringBuilder ans = new StringBuilder();
            Stack<Integer> multiStack = new Stack<>();
            Stack<StringBuilder> ansStack = new Stack<>();
            int multi = 0;
            for (Character x : s.toCharArray()) {
                if (Character.isDigit(x)) {
                    multi *= 10;
                    multi += x - '0';
                } else if (x == '[') {
                    ansStack.push(ans);
                    ans = new StringBuilder();
                    multiStack.push(multi);
                    multi = 0;
                } else if (Character.isLetter(x)) {
                    ans.append(x);
                } else {
                    StringBuilder ansTmp = ansStack.pop();
                    int num = multiStack.pop();
                    while (num-- > 0) {
                        ansTmp.append(ans);
                    }
                    ans = ansTmp;
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new Solution().decodeString(s));
    }
}
