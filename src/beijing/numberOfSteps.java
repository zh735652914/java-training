package beijing;
/*
https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */

public class numberOfSteps {
    // 因为是除夕，所以今天的每日一题这么简单？
    static class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while (num > 0) {
                if (num % 2 == 0) {
                    num = num >> 1;
                } else {
                    num--;
                }
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(new Solution().numberOfSteps(num));
    }
}
