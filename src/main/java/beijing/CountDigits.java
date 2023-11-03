package beijing;

/**
 * @author zhouhao
 * @date 2023/10/26 11:58
 */
public class CountDigits {
    static class Solution {
        // 很简单
        public int countDigits(int num) {
            int count = 0;
            int x = num;
            while (x > 0) {
                int n = x % 10;
                if (num % n == 0) {
                    count++;
                }
                x /= 10;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int num = 121;
        System.out.println(new Solution().countDigits(num));
    }
}
