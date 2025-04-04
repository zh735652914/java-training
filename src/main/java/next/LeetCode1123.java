package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/4/4 08:55
 * https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/?envType=daily-question&envId=2025-04-04
 */
public class LeetCode1123 {
    int maxDeep = 0;
    TreeNode ans = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            maxDeep = Math.max(maxDeep, deep);
            return deep;
        }
        int leftDeep = dfs(root.left, deep + 1);
        int rightDeep = dfs(root.right, deep + 1);
        if (leftDeep == rightDeep && leftDeep == maxDeep) {
            ans = root;
        }
        return Math.max(leftDeep, rightDeep);
    }

    @Test
    public void test() {
        String nodes = "[3,5,1,6,2,0,8,null,null,7,4]";
        TreeNode root = TreeUtils.LevelBuildTree(nodes);
        TreeNode ans = lcaDeepestLeaves(root);
        TreeUtils.printTree(ans);
    }
}
