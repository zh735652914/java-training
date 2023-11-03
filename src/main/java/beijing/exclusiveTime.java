package beijing;
/*
https://leetcode.cn/problems/exclusive-time-of-functions/
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 自己没写出来，得看看
public class exclusiveTime {
    static class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<int[]> stack = new Stack<>();
            int[] ans = new int[n];
            for (String log : logs) {
                String[] work = log.split(":");
                int id = Integer.parseInt(work[0]), time = Integer.parseInt(work[2]);
                if (work[1].equals("start")) {
                    if (!stack.isEmpty()) {
                        ans[stack.peek()[0]] += time - stack.peek()[1];
                        stack.peek()[1] = time;
                    }
                    stack.push(new int[]{id, time});
                } else {
                    int[] lastWork = stack.pop();
                    ans[id] += time - lastWork[1] + 1;
                    if (!stack.isEmpty()) {
                        stack.peek()[1] = time + 1;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 1;
        String[] s = {"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        List<String> logs = new ArrayList<>(List.of(s));
        int[] ans = new Solution().exclusiveTime(n, logs);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
