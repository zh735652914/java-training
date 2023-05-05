package beijing;
/*
https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/
 */

/**
 * @author zhouhao
 * @date 2023/5/5 12:51
 */
public class HardestWorker {
    // 的确是很简单的题
    static class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int maxTime = 0, maxID = 0;
            int lastTime = 0;
            for (int[] log : logs) {
                int time = log[1] - lastTime;
                if (time > maxTime) {
                    maxID = log[0];
                    maxTime = time;
                } else if (time == maxTime) {
                    maxID = Math.min(maxID, log[0]);
                }
                lastTime = log[1];
            }
            return maxID;
        }
    }

    public static void main(String[] args) {
        int n = 26;
        int[][] logs = {{1, 1}, {3, 7}, {2, 12}, {7, 17}};
        System.out.println(new Solution().hardestWorker(n, logs));
    }
}
