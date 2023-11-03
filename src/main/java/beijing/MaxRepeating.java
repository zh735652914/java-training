package beijing;
/*
https://leetcode.cn/problems/maximum-repeating-substring/
 */

public class MaxRepeating {
    // 用别的方法比较好
    static class Solution {
        public int maxRepeating(String sequence, String word) {
            int count = 0;
            String x = word;
            while (sequence.contains(word)) {
                count++;
                word += x;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String sequence = "ababc", word = "ab";
        System.out.println(new Solution().maxRepeating(sequence, word));
    }
}
