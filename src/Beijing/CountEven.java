package Beijing;
/*
https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 */

/**
 * @author zhouhao
 * @date 2023/1/6 12:47
 */
// 的确是简单题
public class CountEven {
    static class Solution {
        public int countEven(int num) {
            int ans = 0;
            for (int i = 1; i <= num; i++) {
                if (isEven(i)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isEven(int num) {
            int sum = 0;
            while (num != 0) {
                sum += (num % 10);
                num /= 10;
            }
            return (sum & 1) == 0;
        }
    }

    public static void main(String[] args) {
        int num = 30;
        System.out.println(new Solution().countEven(num));
    }
}
