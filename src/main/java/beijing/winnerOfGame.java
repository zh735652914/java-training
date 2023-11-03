package beijing;
/*
https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 */

public class winnerOfGame {

    // 评论里写的，真牛逼
    static class Solution {
        public boolean winnerOfGame(String colors) {
            int count = 0;
            for (int i = 0; i < colors.length() - 2; i++) {
                if (colors.startsWith("AAA", i)) {
                    count++;
                }
                if (colors.startsWith("BBB", i)) {
                    count--;
                }
            }
            return count > 0;
        }
    }


    // 自己写的，超时了
    static class Solution0 {
        public boolean winnerOfGame(String colors) {
            StringBuilder stringBuilder = new StringBuilder(colors);
            boolean isATurn = true;
            while (stringBuilder.length() > 2) {
                boolean flagCanFinish = false;
                for (int i = 1; i < stringBuilder.length() - 1; i++) {
                    if (isATurn) {
                        if (canRm(stringBuilder, i, 'A')) {
                            stringBuilder.deleteCharAt(i);
                            flagCanFinish = true;
                            break;
                        }
                    } else {
                        if (canRm(stringBuilder, i, 'B')) {
                            stringBuilder.deleteCharAt(i);
                            flagCanFinish = true;
                            break;
                        }
                    }
                }
                if (!flagCanFinish) {
                    return !isATurn;
                }
                isATurn = !isATurn;
            }
            return !isATurn;
        }

        private boolean canRm(StringBuilder stringBuilder, int index, char x) {
            if (index <= 0 || index >= stringBuilder.length() - 1) {
                return false;
            }
            for (int i = index - 1; i <= index + 1; i++) {
                if (stringBuilder.charAt(i) != x) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String colors = "AA";
        System.out.println(new Solution().winnerOfGame(colors));
    }
}
