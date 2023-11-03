package beijing;
/*
https://leetcode-cn.com/problems/longest-absolute-file-path/
 */

public class lengthLongestPath {
    // 看了评论才写出来的，比较重要！
    static class Solution {
        public int lengthLongestPath(String input) {
            if (input == null || input.length() < 1) {
                return 0;
            }
            String[] words = input.split("\n");
            int[] LevelsLen = new int[words.length + 1];
            int ans = 0;
            LevelsLen[0] = -1;
            for (String word : words) {
                int level = word.lastIndexOf("\t") + 2;
                int len = word.length() - level + 1;
                LevelsLen[level] = LevelsLen[level - 1] + len + 1;
                if (word.contains(".")) {
                    ans = Math.max(ans, LevelsLen[level]);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input = "rzzmf\nv\n\tix\n\t\tiklav\n\t\t\ttqse\n\t\t\t\ttppzf\n\t\t\t\t\tzav\n\t\t\t\t\t\tkktei\n\t\t\t\t\t\t\thhmav\n\t\t\t\t\t\t\t\tbzvwf.txt";
        System.out.println(new Solution().lengthLongestPath(input));
    }
}
