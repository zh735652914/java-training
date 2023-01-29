package beijing;
/*
https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */

import java.util.Random;

// 自己没想到
public class generateRandomPointinaCircle {
    static class Solution {

        private final Random random;
        private final double x_center;
        private final double y_center;
        private final double radius;

        public Solution(double radius, double x_center, double y_center) {
            random = new Random();
            this.x_center = x_center;
            this.y_center = y_center;
            this.radius = radius;
        }

        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * 2 * radius - radius;
                double y = random.nextDouble() * 2 * radius - radius;
                if (x * x + y * y <= radius * radius) {
                    return new double[]{x + x_center, y + y_center};
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        double[] ans = solution.randPoint();
        System.out.println("[ " + ans[0] + ", " + ans[1] + " ]");
    }
}
