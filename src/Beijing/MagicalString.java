package Beijing;
/*
https://leetcode.cn/problems/magical-string/
 */

public class MagicalString {
    // 自己不会写，看了解析才写
    static class Solution {
        public int magicalString(int n) {
            if (n <= 3) {
                return 1;
            }
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 2;
            int left = 2, right = 3;
            int count = 1;
            int x = 1;
            while (left < n) {
                if (arr[left] == 1) {
                    count++;
                }
                int num = arr[left];
                while (right < n && num-- > 0) {
                    arr[right++] = x;
                }
                x ^= 3;
                left++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().magicalString(n));
    }
}
