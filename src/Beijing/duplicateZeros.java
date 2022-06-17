package Beijing;
/*
https://leetcode.cn/problems/duplicate-zeros/
 */

public class duplicateZeros {
    // 这题虽然是简单题，但是并不简单，挺有意思的一道题
    static class Solution {
        public void duplicateZeros(int[] arr) {
            int p = 0, q = 0;
            while (p < arr.length) {
                if (arr[q] == 0) {
                    p++;
                }
                p++;
                q++;
            }
            p--;
            q--;
            while (q >= 0) {
                if (p < arr.length) {
                    arr[p] = arr[q];
                }
                if (arr[q] == 0 && --p > 0) {
                    arr[p] = 0;
                }
                p--;
                q--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new Solution().duplicateZeros(arr);
        for (int x : arr) {
            System.out.print(x + ", ");
        }
    }
}
