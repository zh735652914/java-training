package Beijing;
/*
https://leetcode.cn/problems/task-scheduler/
 */

public class taskScheduler {
    // 看了评论很久才写出来
    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            /*
            time=(countMax-1)*(n+1)+maxCount
             */
            int[] count = new int[26];
            int max = 0;
            int countMax = 1;
            for (int i = 0; i < tasks.length; i++) {
                int index = tasks[i] - 'A';
                count[index]++;
                if (max == count[index]) {
                    countMax++;
                } else if (max < count[index]) {
                    max = count[index];
                    countMax = 1;
                }
            }
            return Math.max((max - 1) * (n + 1) + countMax, tasks.length);
        }
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new Solution().leastInterval(tasks, n));
    }
}
