package beijing;
/*
https://leetcode.cn/problems/find-the-maximum-achievable-number/?envType=daily-question&envId=2024-05-21
 */

/**
 * @author zhouhao
 * @date 2024/5/21 08:20
 */
public class FindtheMaximumAchievableNumber_2769 {
    static class Solution {
        public int theMaximumAchievableX(int num, int t) {
            return num + 2 * t;
        }
    }

    public static void main(String[] args) {
        int num = 4, t = 1;
        System.out.println(new Solution().theMaximumAchievableX(num, t));
    }
}
