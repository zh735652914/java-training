package Beijing.hot100;
/*
https://leetcode.cn/problems/daily-temperatures/
 */

// 第二次了，自己还是不会写
public class dailyTemperatures_739 {
    static class Solution {
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
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new Solution().dailyTemperatures(temperatures);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
