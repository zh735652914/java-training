package Beijing;

/*
https://leetcode-cn.com/problems/add-digits/
 */
public class addDigits {
    // 这题很简单
    static class Solution {
        public int addDigits(int num) {
            if (num < 10) {
                return num;
            }
            int tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
            return addDigits(num);
        }
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(new Solution().addDigits(num));
    }
}
