package Beijing;
/*
https://leetcode.cn/problems/minimum-absolute-difference/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 现在遇到简单题反而不敢写了
public class minimumAbsDifference {
    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] < min) {
                    min = arr[i + 1] - arr[i];
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] == min) {
                    List<Integer> aPair = new ArrayList<>();
                    aPair.add(arr[i]);
                    aPair.add(arr[i + 1]);
                    ans.add(aPair);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        System.out.println(new Solution().minimumAbsDifference(arr));
    }
}
