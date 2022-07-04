package Beijing.hot100;
/*
https://leetcode.cn/problems/task-scheduler/
 */

import java.util.HashMap;
import java.util.Map;

// 第二次写，自己还是不会
public class taskScheduler_621 {
    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] counts = new int[26];
            int maxCount = 0;
            int maxTask = 0;
            for (char task : tasks) {
                int index = task - 'A';
                counts[index]++;
                if (maxCount == counts[index]) {
                    maxTask++;
                } else if (counts[index] > maxCount) {
                    maxCount = counts[index];
                    maxTask = 1;
                }
            }
            return Math.max((n + 1) * (maxCount - 1) + maxTask, tasks.length);
        }
    }

    static class Solution0 {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> map = new HashMap<>();
            int maxCount = 0;
            for (char task : tasks) {
                map.put(task, map.getOrDefault(task, 0) + 1);
                maxCount = Math.max(maxCount, map.get(task));
            }
            int maxTasks = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    maxTasks++;
                }
            }
            return Math.max((n + 1) * (maxCount - 1) + maxTasks, tasks.length);
        }
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new Solution().leastInterval(tasks, n));
    }
}
