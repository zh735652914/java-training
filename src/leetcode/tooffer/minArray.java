package leetcode.tooffer;
/*
面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

通过次数4,480提交次数9,630
 */

import java.util.Scanner;

public class minArray {
    static class Solution {
        public int minArray0(int[] numbers) {
//            int left = 0;
            if (numbers == null || numbers.length == 0) return -1;
            if (numbers.length == 1) return numbers[0];
            int right = numbers.length - 1;
            boolean flag = false;
            while (0 < right) {
                if (numbers[right] <= numbers[0]) {
                    if (numbers[right] == numbers[0] && right < (numbers.length - 1) && flag) {
                        break;
                    }
                    if (numbers[right] < numbers[0]) {
                        flag = true;
                    }
                    right--;
                } else {
                    if (right == numbers.length - 1) {
                        return numbers[0];
                    }
                    break;
                }
            }
            return numbers[++right];
        }

        public int minArray(int[] numbers) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            return numbers[right];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] numbers = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                numbers[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().minArray(numbers));
        }
    }
}
