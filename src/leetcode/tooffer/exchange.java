package leetcode.tooffer;
/*
面试题21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。


提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
通过次数3,892提交次数5,853
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exchange {
    static class Solution {
        public int[] exchange(int[] nums) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    queue.offer(i);
                } else {
                    if (!queue.isEmpty()) {
                        swap(nums, queue.poll(), i);
                        queue.offer(i);
                    }
                }
            }
            return nums;
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
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
            int[] ans = new Solution().exchange(nums);
            for (int x : ans) {
                System.out.print(x + "  ");
            }
        }
    }
}
