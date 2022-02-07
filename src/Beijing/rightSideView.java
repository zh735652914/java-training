package Beijing;
/*
https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            visit(root, 0, ans);
            return ans;
        }

        private void visit(TreeNode root, int deep, List<Integer> ans) {
            if (root == null) {
                return;
            }
            if (ans.size() == deep) {
                ans.add(root.val);
            }
            visit(root.right, deep + 1, ans);
            visit(root.left, deep + 1, ans);
        }
    }

    static class Solution0 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 1) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                    size--;
                }
                TreeNode last = queue.poll();
                ans.add(last.val);
                if (last.left != null) {
                    queue.offer(last.left);
                }
                if (last.right != null) {
                    queue.offer(last.right);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "null", "5", "null", "4"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().rightSideView(root));
    }
}
