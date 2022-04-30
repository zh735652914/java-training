package Beijing;
/*
https://leetcode-cn.com/problems/h-index/
 */

import java.util.Arrays;

// 两个方法自己都不会写
public class hIndex {
    static class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (citations[i] >= n) {
                    count[n]++;
                } else {
                    count[citations[i]]++;
                }
            }
            int sum = 0;
            for (int i = n; i >= 0; i--) {
                sum += count[i];
                if (sum >= i) {
                    return i;
                }
            }
            return 0;
        }
    }

    static class Solution0 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int h = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (citations[i] > h) {
                    h++;
                }
            }
            return h;
        }
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {1, 3, 1};
        System.out.println(new Solution().hIndex(citations));
    }
}
