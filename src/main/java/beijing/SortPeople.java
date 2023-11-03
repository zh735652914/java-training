package beijing;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/4/25 13:25
 */
public class SortPeople {
    // 这种写法自己不会
    static class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Integer[] indexs = new Integer[heights.length];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i] = i;
            }
            Arrays.sort(indexs, (a, b) -> heights[b] - heights[a]);
            String[] ans = new String[names.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = names[indexs[i]];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        String[] ans = new Solution().sortPeople(names, heights);
        for (String x : ans) {
            System.out.print(x + ", ");
        }
    }
}
