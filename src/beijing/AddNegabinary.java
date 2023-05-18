package beijing;
/*
https://leetcode.cn/problems/adding-two-negabinary-numbers/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/5/18 12:45
 */
// 自己不会
public class AddNegabinary {
    static class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            List<Integer> list = new ArrayList<>();
            int i = arr1.length - 1, j = arr2.length - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = carry;
                if (i >= 0) {
                    x += arr1[i];
                }
                if (j >= 0) {
                    x += arr2[j];
                }
                if (x >= 2) {
                    list.add(x - 2);
                    carry = -1;
                } else if (x >= 0) {
                    list.add(x);
                    carry = 0;
                } else {
                    list.add(1);
                    carry = 1;
                }
                i--;
                j--;
            }
            while (list.size() > 1 && list.get(list.size() - 1) == 0) {
                list.remove(list.size() - 1);
            }
            int[] nums = new int[list.size()];
            for (int k = 0; k < nums.length; k++) {
                nums[k] = list.get(nums.length - 1 - k);
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0}, arr2 = {1, 1};
        int[] ans = new Solution().addNegabinary(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }
}
