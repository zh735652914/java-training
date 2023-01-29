package beijing;

import java.util.Scanner;

/*
https://leetcode-cn.com/problems/reverse-integer/
 */
//这种解法很巧妙
public class reverse {
    static class Solution {
        public int reverse(int x) {
            long n = 0;
            while (x != 0) {
                n = n * 10 + x % 10;
                x /= 10;
            }
            return (int) n == n ? (int) n : 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().reverse(scanner.nextInt()));
        }
    }
}
