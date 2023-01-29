package beijing;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode-cn.com/problems/even-odd-tree/
 */
public class isEvenOddTree {
    static class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            boolean flag = false;// 奇数
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            if (root.val % 2 == 0) {
                return false;
            }
            while (!queue.isEmpty()) {
                int count = queue.size();
                int last = queue.peek().val;
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (flag && queue.poll().val % 2 != 0 || !flag && queue.poll().val % 2 == 0) {
                    return false;
                }
                while (--count > 0) {
                    if (flag && queue.peek().val >= last) {
                        return false;
                    }
                    if (!flag && queue.peek().val <= last) {
                        return false;
                    }
                    if (queue.peek().left != null) {
                        queue.offer(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.offer(queue.peek().right);
                    }
                    last = queue.poll().val;
                    if (flag && last % 2 != 0 || !flag && last % 2 == 0) {
                        return false;
                    }
                }
                flag = !flag;
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        String[] nodes = {"1", "10", "4", "3", "null", "7", "9", "12", "8", "6", "null", "null", "2"};
        String[] nodes = {"5", "4", "2", "3", "3", "7"};
//        String[] nodes = {"5", "9", "1", "3", "5", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        new PrintTree().LevelPrintTree(root);
        System.out.println();
        System.out.println(new Solution().isEvenOddTree(root));
    }
}
