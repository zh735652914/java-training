package leetcode.programmerInterview;
/*面试题 16.01. 交换数字
编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。

示例：

输入: numbers = [1,2]
输出: [2,1]
提示：

numbers.length == 2
通过次数9,214提交次数11,150
 */

//这题感觉有点智障。。
public class swapNumbers {
    static class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] + numbers[1];
            numbers[1] = numbers[0] - numbers[1];
            numbers[0] = numbers[0] - numbers[1];
            return numbers;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2};
        int[] ans = new Solution().swapNumbers(numbers);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
