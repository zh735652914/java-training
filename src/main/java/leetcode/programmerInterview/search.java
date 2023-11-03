package leetcode.programmerInterview;
/*
面试题 10.03. 搜索旋转数组
搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

示例1:

 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 输出: 8（元素5在该数组中的索引）
示例2:

 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 输出：-1 （没有找到）
提示:

arr 长度范围在[1, 1000000]之间
通过次数3,946提交次数10,171
 */

import java.util.Scanner;

//不会写。。。自己没想到
public class search {
    static class Solution {
        public int search(int[] arr, int target) {
            int len = arr.length;
            while (len > 1 && arr[len - 1] == arr[0]) {
                len--;
            }
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= arr[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            right = left + len - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (target <= arr[mid % len]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (arr[left % len] == target) {
                return left % len;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().search(arr, scanner.nextInt()));
        }
    }
}
