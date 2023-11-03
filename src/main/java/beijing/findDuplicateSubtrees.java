package beijing;
/*
https://leetcode.cn/problems/find-duplicate-subtrees/
 */

import java.util.*;

// 不是自己写的，自己不会写
public class findDuplicateSubtrees {
    static class Solution {
        Map<String, Integer> map = new HashMap<>();//存储节点对应唯一标志flag和 子树idx
        Map<Integer, TreeNode> idxMap = new HashMap<>();//存储idx和对应子树根节点，方便生成返回列表
        Set<Integer> repeat = new HashSet<>();//用于存储重复子树的唯一序号idx
        int idx = 0;// 每个子树对应的唯一序号

        // 主函数 寻找重复的子树
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            List<TreeNode> list = new ArrayList<>();
            for (int i : repeat) list.add(idxMap.get(i));// 将idx映射为对应子树的根节点
            return list;
        }

        // 辅助函数 深度优先遍历所有节点,返回“节点作为根节点的子树”对应的唯一序号idx
        public int dfs(TreeNode node) {
            if (node == null) return 0; // 空节点对应序号0 递归结束
            int[] tri = {node.val, dfs(node.left), dfs(node.right)};// DFS实现自底向上，先生成子树的idx
            String flag = Arrays.toString(tri); // 当前树节点+子树序号就是当前树的唯一标志，flag相同就代表树相同
            if (map.containsKey(flag)) { // 当前二叉树重复
                int Ridx = map.get(flag);
                repeat.add(Ridx); //加入重复子树的唯一序号idx
                return Ridx;
            } else { // 当前二叉树第一次出现，结合未使用过的idx，加入哈希Map，
                map.put(flag, ++idx);//<flag,idx>生成这个映射为了减少时间和空间，用idx表示子树O(1),用flag表示子树O(n)
                idxMap.put(idx, node);//<子树唯一序号idx,子树根节点>，方便生成题目返回值
                return idx;
            }
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,3,4,null,2,4,null,null,4]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        List<TreeNode> ans = new Solution().findDuplicateSubtrees(root);
        for (TreeNode T : ans) {
            new PrintTree().LevelPrintTree(T);
            System.out.println();
        }
    }
}
