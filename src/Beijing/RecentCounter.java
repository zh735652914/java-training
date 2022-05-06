package Beijing;
/*
https://leetcode-cn.com/problems/number-of-recent-calls/
 */

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int minT = t - 3000;
        while (!queue.isEmpty() && queue.peek() < minT) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        String[] ops = {"RecentCounter", "ping", "ping", "ping", "ping"};
        int[][] times = {{}, {1}, {100}, {3001}, {3002}};
        RecentCounter recentCounter = new RecentCounter();
        for (int i = 1; i < ops.length; i++) {
            System.out.print(recentCounter.ping(times[i][0]) + ", ");
        }
    }
}
