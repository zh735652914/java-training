package leetcode.tooffer;
/*
面试题39. 数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。



你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2


限制：

1 <= 数组长度 <= 50000



注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/



通过次数4,509提交次数6,812
 */

import java.util.Arrays;
import java.util.Scanner;

public class majorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int major = nums[0], max = 1, count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == major) {
                    max++;
                    if (max > (nums.length / 2)) break;
                } else {
                    if (nums[i] == nums[i - 1]) {
                        count++;
                        if (count > max) {
                            major = nums[i];
                            max = count;
                        }
                    } else {
                        count = 1;
                    }
                }
            }
            return major;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().majorityElement(nums));
        }
    }
}
