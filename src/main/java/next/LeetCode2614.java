package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/18 08:26
 * https://leetcode.cn/problems/prime-in-diagonal/description/?envType=daily-question&envId=2025-03-18
 */
public class LeetCode2614 {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) {
                ans = nums[i][i];
            }
            if (nums[i][nums.length - 1 - i] > ans && isPrime(nums[i][nums.length - 1 - i])) {
                ans = nums[i][nums.length - 1 - i];
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return x >= 2;
    }

    @Test
    public void test() {
        int[][] nums = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        System.out.println(diagonalPrime(nums));
    }
}
