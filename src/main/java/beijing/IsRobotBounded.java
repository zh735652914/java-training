package beijing;
/*
https://leetcode.cn/problems/robot-bounded-in-circle/
 */

/**
 * @author zhouhao
 * @date 2023/4/11 12:46
 */
public class IsRobotBounded {
    // 主要是看解析的分析
    static class Solution {
        public boolean isRobotBounded(String instructions) {
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int D = 0, x = 0, y = 0;
            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) == 'G') {
                    x += dirs[D][0];
                    y += dirs[D][1];
                } else if (instructions.charAt(i) == 'L') {
                    D += 3;
                } else {
                    D++;
                }
                D %= 4;
            }
            return x == 0 && y == 0 || D != 0;
        }
    }

    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(new Solution().isRobotBounded(instructions));
    }
}
