package Beijing;
/*
https://leetcode.cn/problems/count-and-say/
 */

// 题目弄懂就行
public class countandSay_38_topInterviewList {
    static class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            String last = countAndSay(n - 1);
            int len = last.length();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < len; i++) {
                int count = 0;
                int pos = i;
                while (pos < len && last.charAt(pos) == last.charAt(i)) {
                    count++;
                    pos++;
                }
                ans.append(count);
                ans.append(last.charAt(i));
                i = pos - 1;
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().countAndSay(n));
    }
}
