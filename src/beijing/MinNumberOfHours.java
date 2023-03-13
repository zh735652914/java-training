package beijing;
/*
https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 */

/**
 * @author zhouhao
 * @date 2023/3/13 19:53
 */
public class MinNumberOfHours {
    // 简单题我都不太会了
    static class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int sum = 0;
            for (int e : energy) {
                sum += e;
            }
            int ans = initialEnergy > sum ? 0 : sum - initialEnergy + 1;
            for (int exp : experience) {
                if (exp >= initialExperience) {
                    ans += exp - initialExperience + 1;
                    initialExperience = 2 * exp + 1;
                } else {
                    initialExperience += exp;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1, 4, 3, 2}, experience = {2, 6, 3, 1};
        System.out.println(new Solution().minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
}
