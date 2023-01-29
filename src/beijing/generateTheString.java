package beijing;
/*
https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */

// 自己一开始没想到，但是的确挺没意思的
public class generateTheString {
    static class Solution {
        public String generateTheString(int n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("a".repeat(Math.max(0, n - 1)));
            if ((n & 1) == 1) {
                stringBuilder.append('a');

            } else {
                stringBuilder.append('b');
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().generateTheString(n));
    }
}
