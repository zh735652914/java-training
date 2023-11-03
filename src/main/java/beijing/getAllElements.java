package beijing;
/*
https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */

import java.util.ArrayList;
import java.util.List;

// 自己一开始想一起递归，递不出来
public class getAllElements {
    static class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> t1 = new ArrayList<>();
            List<Integer> t2 = new ArrayList<>();
            visit(root1, t1);
            visit(root2, t2);
            int a = 0, b = 0;
            int len1 = t1.size(), len2 = t2.size();
            while (a < len1 && b < len2) {
                if (t1.get(a) <= t2.get(b)) {
                    ans.add(t1.get(a));
                    a++;
                } else {
                    ans.add(t2.get(b));
                    b++;
                }
            }
            while (a < len1) {
                ans.add(t1.get(a));
                a++;
            }
            while (b < len2) {
                ans.add(t2.get(b));
                b++;
            }
            return ans;
        }

        private void visit(TreeNode root, List<Integer> t) {
            if (root == null) {
                return;
            }
            visit(root.left, t);
            t.add(root.val);
            visit(root.right, t);
        }
    }

    public static void main(String[] args) {
        String[] nodes1 = {"2", "1", "4"}, nodes2 = {"1", "0", "3"};
        TreeNode root1 = new BuildTree().LevelBuildTree(nodes1);
        TreeNode root2 = new BuildTree().LevelBuildTree(nodes2);
        System.out.println(new Solution().getAllElements(root1, root2));
    }
}
