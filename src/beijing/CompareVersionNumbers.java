package beijing;
/*
https://leetcode-cn.com/problems/compare-version-numbers/
 */

public class CompareVersionNumbers {
    // 情况得考虑清楚
    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] V1 = version1.split("\\.");
            String[] V2 = version2.split("\\.");
            int n = Math.min(V1.length, V2.length);
            int i;
            for (i = 0; i < n; i++) {
                int A = getNum(V1[i]);
                int B = getNum(V2[i]);
                if (A > B) {
                    return 1;
                }
                if (A < B) {
                    return -1;
                }
            }
            if (V1.length > V2.length) {
                return tail(V1, i, true);
            } else {
                return tail(V2, i, false);
            }
        }

        private int tail(String[] X, int index, boolean isV1) {
            while (index < X.length) {
                if (getNum(X[index]) == 0) {
                    index++;
                    continue;
                }
                return isV1 ? 1 : -1;
            }
            return 0;
        }

        private int getNum(String x) {
            if (x == null) {
                return 0;
            }
            int index = 0;
            while (index < x.length() && x.charAt(index) == '0') {
                index++;
            }
            if (index == x.length()) {
                return 0;
            }
            return Integer.parseInt(x.substring(index));
        }
    }

    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1";
        System.out.println(new Solution().compareVersion(version1, version2));
    }
}
