package beijing;
/*
https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */

// 一开始题目没看明白
public class minDeletionSize {
    static class Solution {
        public int minDeletionSize(String[] strs) {
            int len = strs[0].length();
            int last, count = 0;
            for (int i = 0; i < len; i++) {
                last = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) < last) {
                        count++;
                        break;
                    } else {
                        last = strs[j].charAt(i);
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};
        System.out.println(new Solution().minDeletionSize(strs));
    }
}
