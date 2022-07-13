package Beijing;
/*
https://leetcode.cn/problems/asteroid-collision/
 */

import java.util.Stack;

public class asteroidCollision {
    // 官方解析还是牛逼，自己写成了屎山
    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int asteroid : asteroids) {
                boolean alive = true;
                while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    alive = -asteroid > stack.peek();
                    if (-asteroid >= stack.peek()) {
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(asteroid);
                }
            }
            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] asteroids = {-2, -1, 1, 2};
        int[] ans = new Solution().asteroidCollision(asteroids);
        for (int num : ans) {
            System.out.print(num + ", ");
        }
    }
}
