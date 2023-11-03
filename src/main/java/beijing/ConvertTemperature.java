package beijing;
/*
https://leetcode.cn/problems/convert-the-temperature/
 */

/**
 * @author zhouhao
 * @date 2023/3/21 12:44
 */
public class ConvertTemperature {
    // 这题没有意义
    static class Solution {
        public double[] convertTemperature(double celsius) {
            double[] ans = new double[2];
            ans[0] = celsius + 273.15;
            ans[1] = celsius * 1.80 + 32.00;
            return ans;
        }
    }

    public static void main(String[] args) {
        double celsius = 36.50;
        double[] ans = new Solution().convertTemperature(celsius);
        for (double x : ans) {
            System.out.print(x + ", ");
        }
    }
}
