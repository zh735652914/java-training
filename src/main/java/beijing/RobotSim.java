package beijing;
/*
https://leetcode.cn/problems/walking-robot-simulation/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/7/19 13:22
 */
public class RobotSim {
    static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            int x = 0, y = 0, d = 1;
            Set<Integer> set = new HashSet<>();
            for (int[] obstacle : obstacles) {
                set.add(obstacle[0] * 60001 + obstacle[1]);   // 把二维坐标改为直线
            }
            int ans = 0;
            for (int command : commands) {
                if (command < 0) {
                    d += command == -1 ? 1 : -1;
                    d %= 4;
                    if (d < 0) {
                        d += 4;
                    }
                } else {
                    for (int i = 0; i < command; i++) {
                        if (set.contains((x + dirs[d][0]) * 60001 + (y + dirs[d][1]))) {
                            break;
                        }
                        x += dirs[d][0];
                        y += dirs[d][1];
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(new Solution().robotSim(commands, obstacles));
    }
}
