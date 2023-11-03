package leetcode.tooffer;
/*
面试题56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。



示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1


限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31


通过次数3,694提交次数4,738
 */

import java.util.Arrays;
import java.util.Scanner;

//自己没想到。。。
public class singleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                    i += 2;
                } else {
                    return nums[i];
                }
            }
            return nums[nums.length - 1];
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
            System.out.println(new Solution().singleNumber(nums));
        }
    }
}
