package beijing;
/*
https://leetcode.cn/problems/maximum-swap/
 */

// 自己没写出来，不会写，看了解析才知道的
public class maximumSwap {
    static class Solution {
        public int maximumSwap(int num) {
            char[] charArray = String.valueOf(num).toCharArray();
            int n = charArray.length;
            int maxIdx = n - 1;
            int idx1 = -1, idx2 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (charArray[i] > charArray[maxIdx]) {
                    maxIdx = i;
                } else if (charArray[i] < charArray[maxIdx]) { // 要保证最大的数是最右边的
                    idx1 = i;
                    idx2 = maxIdx;
                }
            }
            if (idx1 >= 0) {
                swap(charArray, idx1, idx2);
                return Integer.parseInt(String.valueOf(charArray));
            } else {
                return num;
            }
        }

        public void swap(char[] charArray, int i, int j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }

    public static void main(String[] args) {
        int num = 2736;
        System.out.println(new Solution().maximumSwap(num));
    }
}
