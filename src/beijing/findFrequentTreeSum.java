package beijing;
/*
https://leetcode.cn/problems/most-frequent-subtree-sum/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 这个计算子树和需要看看
public class findFrequentTreeSum {
    static class Solution {
        private Map<Integer, Integer> map;

        public int[] findFrequentTreeSum(TreeNode root) {
            map = new HashMap<>();
            getSub(root);
            int maxCount = 0;
            for (int count : map.values()) {
                maxCount = Math.max(count, maxCount);
            }
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    list.add(entry.getKey());
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        private int getSub(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = getSub(root.left);
            int R = getSub(root.right);
            int sum = L + R + root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "2", "-5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int[] ans = new Solution().findFrequentTreeSum(root);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
