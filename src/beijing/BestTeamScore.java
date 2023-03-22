package beijing;
/*
https://leetcode.cn/problems/best-team-with-no-conflicts/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/3/22 12:42
 */
public class BestTeamScore {
    // 又是自己不会写的一题，自己真垃圾
    static class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int[][] people = new int[scores.length][2];
            for (int i = 0; i < people.length; i++) {
                people[i][0] = scores[i];
                people[i][1] = ages[i];
            }
            Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
            int[] dp = new int[scores.length];
            int ans = 0;
            for (int i = 0; i < scores.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (people[j][1] <= people[i][1]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += people[i][0];
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 10, 15}, ages = {1, 2, 3, 4, 5};
        System.out.println(new Solution().bestTeamScore(scores, ages));
    }
}
