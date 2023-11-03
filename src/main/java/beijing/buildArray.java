package beijing;
/*
https://leetcode.cn/problems/build-an-array-with-stack-operations/
 */

import java.util.ArrayList;
import java.util.List;

// 应该是简单题，结果我不会写
public class buildArray {
    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            int index = 0;
            for (int num = 1; num <= n; num++) {
                if (index >= target.length) {
                    break;
                }
                ans.add("Push");
                if (num == target[index]) {
                    index++;
                } else {
                    ans.add("Pop");
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(new Solution().buildArray(target, n));
    }
}
