package LeetCode.ProgrammerInterview;
/*
面试题 04.09. 二叉搜索树序列
从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。

示例:
给定如下二叉树

        2
       / \
      1   3
返回:

[
   [2,1,3],
   [2,3,1]
]
通过次数1,085提交次数2,461
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//这题不会写，看了答案勉强写出来，感觉下次自己写还是不会
public class BSTSequences {
    static class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> BSTSequences(TreeNode root) {
            ans = new LinkedList<>();
            if (root == null) {
                ans.add(new LinkedList<>());
                return ans;
            }
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            backtrack(root, list, new ArrayList<>());
            return ans;
        }

        private void backtrack(TreeNode root, List<Integer> list, List<TreeNode> queue) {
            if (root == null) return;
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
            if (queue.isEmpty()) {
                ans.add(new LinkedList<>(list));
                return;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.get(i);
                List<Integer> nextlist = new LinkedList<>(list);
                nextlist.add(p.val);
                List<TreeNode> nextqueue = new ArrayList<>(queue);
                nextqueue.remove(i);
                backtrack(p, nextlist, nextqueue);
            }
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"2", "1", "3"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        System.out.println(new Solution().BSTSequences(root));
    }
}
