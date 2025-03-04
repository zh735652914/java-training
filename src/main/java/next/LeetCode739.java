package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/4 08:12
 * https://leetcode.cn/problems/daily-temperatures/description/
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += ans[j]) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures(temperatures);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
