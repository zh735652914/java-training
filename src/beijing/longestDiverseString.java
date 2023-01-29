package beijing;
/*
https://leetcode-cn.com/problems/longest-happy-string/
 */

import java.util.Arrays;

public class longestDiverseString {
    static class Solution {
        public String longestDiverseString(int a, int b, int c) {
            StringBuilder ans = new StringBuilder();
            pair[] arr = {new pair(a, 'a'), new pair(b, 'b'), new pair(c, 'c')};
            while (true) {
                Arrays.sort(arr, (p1, p2) -> p2.getCount() - p1.getCount());
                boolean next = false;
                for (pair x : arr) {
                    if (x.getCount() <= 0) {
                        break;
                    }
                    int len = ans.length();
                    if (len >= 2 && ans.charAt(len - 2) == x.getCh() && ans.charAt(len - 1) == x.getCh()) {
                        continue;
                    }
                    next = true;
                    ans.append(x.getCh());
                    x.setCount(x.getCount() - 1);
                    break;
                }
                if (!next) {
                    break;
                }
            }
            return ans.toString();
        }
    }

    static class pair {
        private int count;
        private char ch;

        public pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public char getCh() {
            return ch;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        System.out.println((new Solution().longestDiverseString(a, b, c)));
    }
}
