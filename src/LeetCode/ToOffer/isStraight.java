package LeetCode.ToOffer;
/*
面试题61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
可以看成任意数字。A 不能视为 14。



示例 1:

输入: [1,2,3,4,5]
输出: True


示例 2:

输入: [0,0,1,2,5]
输出: True


限制：

数组长度为 5

数组的数取值为 [0, 13] .

通过次数3,478提交次数8,171
 */

import java.util.Arrays;
import java.util.Scanner;

public class isStraight {
    static class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeros = 0, last = -1;
            for (int num : nums) {
                if (num == 0) {
                    zeros++;
                } else {
                    if (last == -1) {
                        last = num;
                    } else if (last == num) {
                        return false;
                    } else {
                        zeros = zeros - (num - last) + 1;
                        last = num;
                        if (zeros < 0) {
                            return false;
                        }
                    }
                }
            }
            return zeros != nums.length;
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
            System.out.println(new Solution().isStraight(nums));
        }
    }
}
