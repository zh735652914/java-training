package beijing;
/*
https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 */

public class maxConsecutiveAnswers {
    // 这个滑动窗口很重要，自己不会写
    static class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
        }

        private int maxConsecutiveChar(String answerKey, int k, char ch) {
            int count = 0;
            int ans = 0;
            for (int right = 0, left = 0; right < answerKey.length(); right++) {
                count += answerKey.charAt(right) != ch ? 1 : 0;
                while (count > k) {
                    count -= answerKey.charAt(left) != ch ? 1 : 0;
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(new Solution().maxConsecutiveAnswers(answerKey, k));
    }
}
