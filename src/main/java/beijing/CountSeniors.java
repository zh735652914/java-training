package beijing;
/*
https://leetcode.cn/problems/number-of-senior-citizens/?envType=daily-question&envId=2023-10-23
 */

/**
 * @author zhouhao
 * @date 2023/10/23 15:40
 */
public class CountSeniors {

    static class Solution {
        // 很简单
        public int countSeniors(String[] details) {
            int count = 0;
            for (String detail : details) {
                int age = Integer.parseInt(detail.substring(11, 13));
                if (age > 60) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(new Solution().countSeniors(details));
    }
}
