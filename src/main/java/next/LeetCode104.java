package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/23 15:30
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeUtils treeUtils = new TreeUtils();
        assertEquals(3, maxDepth(TreeUtils.LevelBuildTree(nodes)));
    }
}
