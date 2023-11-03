package nowcoder;
/*

https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=117&&tqId=35269&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking

 牛客题霸-名企高频面试题
容器盛水问题
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：269
 算法知识视频讲解
题目描述
给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
具体请参考样例解释
示例1
输入
复制
[3,1,2,5,2,4]
输出
复制
5
说明

示例2
输入
复制
[4,5,1,3,2]
输出
复制
2
备注:
1 \leq N \leq 10^61≤N≤10
6
 */

public class maxWater {
    static public class Solution {
        /**
         * max water
         *
         * @param arr int整型一维数组 the array
         * @return long长整型
         */
        public long maxWater(int[] arr) {
            int[] LtR = new int[arr.length];
            int[] RtL = new int[arr.length];
            LtR[0] = arr[0];
            RtL[arr.length - 1] = arr[arr.length - 1];
            for (int i = 1; i < arr.length; i++) {
                LtR[i] = Math.max(arr[i], LtR[i - 1]);
            }
            for (int i = arr.length - 2; i >= 0; i--) {
                RtL[i] = Math.max(RtL[i + 1], arr[i]);
            }
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans += Math.min(LtR[i], RtL[i]) - arr[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 2, 4};
        System.out.println(new Solution().maxWater(nums));
    }
}
