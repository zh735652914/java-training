package Beijing;
/*
https://leetcode-cn.com/problems/h-index-ii/
 */

public class hIndexII {
    // 得看看这个二分
    static class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (citations[mid] >= (n - mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return n - left;
        }
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
//        int[] citations = {0};
        System.out.println(new Solution().hIndex(citations));
    }
}
