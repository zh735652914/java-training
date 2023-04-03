package beijing;
/*
https://leetcode.cn/problems/previous-permutation-with-one-swap/
 */

/**
 * @author zhouhao
 * @date 2023/4/3 20:05
 */
public class PrevPermOpt1 {
    // 我真菜
    static class Solution {
        public int[] prevPermOpt1(int[] arr) {
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int left = arr.length - 1;
                    while (arr[left] >= arr[i] || arr[left] == arr[left - 1]) {
                        left--;
                    }
                    int tmp = arr[left];
                    arr[left] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 6, 7};
        int[] ans = new Solution().prevPermOpt1(arr);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
