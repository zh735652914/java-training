package nowcoder;
/*
 牛客题霸-名企高频面试题
丑数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：503022
本题知识点： 数学 二分
 算法知识视频讲解
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.Scanner;

public class GetUglyNumber {
    static public class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index <= 0) {
                return 0;
            }
            int[] nums = new int[index];
            nums[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for (int i = 1; i < index; i++) {
                int x = Math.min(nums[p2] * 2, Math.min(nums[p3] * 3, nums[p5] * 5));
                if (x == nums[p2] * 2) {
                    p2++;
                }
                if (x == nums[p3] * 3) {
                    p3++;
                }
                if (x == nums[p5] * 5) {
                    p5++;
                }
                nums[i] = x;
            }
            return nums[index - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().GetUglyNumber_Solution(scanner.nextInt()));
        }
    }
}
