package beijing;
/*
https://leetcode.cn/problems/h-index-ii/?envType=daily-question&envId=2023-10-30
 */

/**
 * @author zhouhao
 * @date 2023/10/30 17:10
 */
public class H_IndexII_275 {
    // 自己还是不会
    static class Solution {
        public int hIndex(int[] citations) {
            int left = 0, right = citations.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (citations[mid] >= citations.length - mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return citations.length - left;
        }
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(new Solution().hIndex(citations));
    }
}
