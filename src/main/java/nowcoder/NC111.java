package nowcoder;
/*
 牛客题霸-名企高频面试题
最大数
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：618
本题知识点： 排序
 算法知识视频讲解
题目描述
给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
示例1
输入
复制
[30,1]
输出
复制
"301"
备注:
输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

public class NC111 {
    static public class Solution {
        /**
         * 最大数
         *
         * @param nums int整型一维数组
         * @return string字符串
         */
        public String solve(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                int left = 0, right = i - 1;
                int tmp = nums[i];
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (cmp(nums[i], nums[mid])) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                for (int j = i; j > left; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[left] = tmp;
            }
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = false;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] != 0) {
                    flag = true;
                }
                stringBuilder.append(nums[i]);
            }
            if (!flag) {
                return "0";
            }
            return stringBuilder.toString();
        }

        private boolean cmp(int x, int y) {
            String s1 = Integer.toString(x);
            String s2 = Integer.toString(y);
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                return s1.charAt(i) > s2.charAt(i);
            }
            return s1.length() < s2.length();
        }
    }

    public static void main(String[] args) {
        int[] nums = {91, 92, 9, 90, 99, 100};
        System.out.println(new Solution().solve(nums));
    }
}
