package Beijing;
/*
https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class busiestServers {
    // 这是官方解析，自己写的超时了
    static class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> (a - b));
            PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
            for (int i = 0; i < k; i++) {
                available.add(i);
            }
            int[] countServerWork = new int[k];
            for (int i = 0; i < arrival.length; i++) {
                while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                    int id = busy.poll()[1];
                    available.add(i + ((id - i) % k + k) % k); // 这个是最难的
                }
                if (available.isEmpty()) {
                    continue;
                }
                int server = available.poll() % k;
                countServerWork[server]++;
                busy.offer(new int[]{arrival[i] + load[i], server});
            }
            List<Integer> ans = new ArrayList<>();
            int maxCount = 0;
            for (int x : countServerWork) {
                maxCount = Math.max(maxCount, x);
            }
            for (int i = 0; i < countServerWork.length; i++) {
                if (countServerWork[i] == maxCount) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    // 自己写的，超时了
    static class Solution0 {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            int[] serversFreeTime = new int[k];
            int[] countServerWork = new int[k];
            int time = 0;
            for (int i = 0; i < arrival.length; i++) {
                time = arrival[i];
                int count = 0;
                while (count < k) {
                    int server = (i + count) % k;
                    if (time >= serversFreeTime[server]) {
                        serversFreeTime[server] = time + load[i];
                        countServerWork[server]++;
                        break;
                    }
                    count++;
                }
            }
            List<Integer> ans = new ArrayList<>();
            int maxCount = 0;
            for (int x : countServerWork) {
                maxCount = Math.max(maxCount, x);
            }
            for (int i = 0; i < countServerWork.length; i++) {
                if (countServerWork[i] == maxCount) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arrival = {1, 2, 3, 4, 8, 9, 10}; // 到达时间
        int[] load = {5, 2, 10, 3, 1, 2, 2}; // 处理时间
        System.out.println(new Solution().busiestServers(k, arrival, load));
    }
}
