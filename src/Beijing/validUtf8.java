package Beijing;
/*
https://leetcode-cn.com/problems/utf-8-validation/
 */

public class validUtf8 {
    static class Solution {
        public boolean validUtf8(int[] data) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] >> 7 == 0) {
                    continue;
                } else if (data[i] >> 5 == 6) {
                    if (!vaildTail(data, i, 1)) {
                        return false;
                    }
                    i += 1;
                } else if (data[i] >> 4 == 14) {
                    if (!vaildTail(data, i, 2)) {
                        return false;
                    }
                    i += 2;
                } else if (data[i] >> 3 == 30) {
                    if (!vaildTail(data, i, 3)) {
                        return false;
                    }
                    i += 3;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean vaildTail(int[] data, int index, int count) {
            while (count-- > 0) {
                index++;
                if (index >= data.length || data[index] >> 6 != 2) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] data = {255};
        System.out.println(new Solution().validUtf8(data));
    }
}
