package leetcode;
/*
621. Task Scheduler
Medium

2216

436

Add to List

Share
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different
letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.



Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */

//哎。。依旧是自己不会写，但是非常重要！！！！！！！！！！！！！！
class TaskSchedulerSloution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0, MaxCount = 0;
        for (char x : tasks) {
            counter[x - 'A']++;
            if (counter[x - 'A'] == max) {
                MaxCount++;
            } else if (max < counter[x - 'A']) {
                MaxCount = 1;
                max = counter[x - 'A'];
            }
        }
        int part = max - 1;
        int PartLen = Math.max(0, n - MaxCount + 1);
        return tasks.length + Math.max(0, part * PartLen - (tasks.length - max * MaxCount));
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new TaskSchedulerSloution().leastInterval(tasks, n));
    }
}
