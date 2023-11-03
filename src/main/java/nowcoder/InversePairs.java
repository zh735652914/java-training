package nowcoder;
/*
 牛客题霸-名企高频面试题
数组中的逆序对 相似的企业真题
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 32M，其他语言64M 热度指数：610646
本题知识点： 数组
 算法知识视频讲解
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5

示例1
输入
复制
1,2,3,4,5,6,7,0
输出
复制
7
 */

public class InversePairs {
    static public class Solution {
        public int InversePairs(int[] array) {
            return backtrack(array, 0, array.length - 1);
        }

        private int backtrack(int[] nums, int start, int end) {
            if (start >= end) {
                return 0;
            }
            int mid = (start + end) / 2;
            int left = backtrack(nums, start, mid) % 1000000007;
            int right = backtrack(nums, mid + 1, end) % 1000000007;
            int all = merge(nums, start, end) % 1000000007;
            return (left + right + all) % 1000000007;
        }

        private int merge(int[] nums, int start, int end) {
            int mid = (start + end) / 2;
            int[] tmp = new int[end - start + 1];
            int index = 0;
            int count = 0;
            int L = start, R = mid + 1;
            while (L <= mid && R <= end) {
                if (nums[L] > nums[R]) {
                    count += (mid - L + 1);
                    count %= 1000000007;
                    tmp[index++] = nums[R++];
                } else {
                    tmp[index++] = nums[L++];
                }
            }
            while (L <= mid) {
                tmp[index++] = nums[L++];
            }
            while (R <= end) {
                tmp[index++] = nums[R++];
            }
            System.arraycopy(tmp, 0, nums, start + 0, tmp.length);
            return count;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] nums = {5, 1, 1, 1};
        System.out.println(new Solution().InversePairs(nums));
    }
}
