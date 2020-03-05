package LeetCode.ToOffer;

import java.util.Scanner;

/*
面试题33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true


提示：

数组长度 <= 1000
通过次数2,521提交次数5,174
 */
public class verifyPostorder {
    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) return true;
            if (postorder.length <= 3) return true;
            return backtrack(postorder, 0, postorder.length - 1);
        }

        private boolean backtrack(int[] postorder, int begin, int end) {
            if (begin >= end) return true;
            int p = begin;
            int q = end - 1;
            while (p < end && postorder[p] < postorder[end]) {
                p++;
            }
            while (q >= begin && postorder[q] > postorder[end]) {
                q--;
            }
            if (p < q) return false;
            return backtrack(postorder, begin, p - 1) && backtrack(postorder, q + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] postorder = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                postorder[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().verifyPostorder(postorder));
        }
    }
}
