package LeetCode.ToOffer;
/*
面试题66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。



示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]


提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000
通过次数3,138提交次数5,345
 */

import java.util.Scanner;

//不会写。。。想不到这样。。。
public class constructArr {
    static class Solution {
        public int[] constructArr(int[] a) {
            int[] ans = new int[a.length];
            for (int i = 0, product = 1; i < a.length; i++) {
                ans[i] = product;
                product *= a[i];
            }
            for (int i = a.length - 1, product = 1; i >= 0; i--) {
                ans[i] *= product;
                product *= a[i];
            }
            return ans;
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
            int[] ans = new Solution().constructArr(nums);
            for (int x : ans) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
