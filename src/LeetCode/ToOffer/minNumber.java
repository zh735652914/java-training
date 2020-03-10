package LeetCode.ToOffer;
/*
面试题45. 把数组排成最小的数
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。



示例 1:

输入: [10,2]
输出: "102"
示例 2:

输入: [3,30,34,5,9]
输出: "3033459"


提示:

0 < nums.length <= 100
说明:

输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
通过次数2,542提交次数4,555
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//不会写。。。java的一些方法用的不熟悉
public class minNumber {
    static class Solution {
        public String minNumber(int[] nums) {
            List<String> list = new LinkedList<>();
            for (int x : nums) {
                list.add(String.valueOf(x));
            }
            list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            return String.join("", list);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().minNumber(nums));
        }
    }
}
