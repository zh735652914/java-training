package LeetCode.ToOffer;
/*
面试题57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]


限制：

1 <= target <= 10^5


通过次数22,023提交次数32,173
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//不会写。。。别人的思路太强了。。。
public class findContinuousSequence {
    static class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new LinkedList<>();
            int len = 1;
            while (target > 0) {
                target -= len++;
                if (target > 0 && target % len == 0) {
                    int[] aNUM = new int[len];
                    for (int i = 0, num = target / len; i < len; i++, num++) {
                        aNUM[i] = num;
                    }
                    list.add(aNUM);
                }
            }
            Collections.reverse(list);
            return list.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[][] ans = new Solution().findContinuousSequence(scanner.nextInt());
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    System.out.print(ans[i][j] + ",");
                }
                System.out.println();
            }
        }
    }
}
