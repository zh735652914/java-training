package beijing;
/*
https://leetcode.cn/problems/h-index/description/?envType=daily-question&envId=2023-10-29
 */

/**
 * @author zhouhao
 * @date 2023/10/29 14:01
 */
public class H_Index_274 {
    // 还是不会写
    static class Solution {
        public int hIndex(int[] citations) {
            int[] count = new int[citations.length + 1];
            for (int citation : citations) {
                if (citation >= citations.length) {
                    count[count.length - 1]++;
                } else {
                    count[citation]++;
                }
            }
            int ans = 0;
            for (int i = count.length - 1; i >= 0; i--) {
                ans += count[i];
                if (ans >= i) {
                    return i;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new Solution().hIndex(citations));
    }
}
