package next;

import next.utils.BuildTree;
import next.utils.TreeNode;
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
        BuildTree buildTree = new BuildTree();
        assertEquals(3, maxDepth(buildTree.LevelBuildTree(nodes)));
    }
}
