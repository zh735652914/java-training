package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/23 11:45
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> aLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                aLevel.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(aLevel);
        }
        return ans;
    }

    @Test
    public void test() {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeUtils treeUtils = new TreeUtils();
        assertEquals("[[3], [9, 20], [15, 7]]", String.valueOf(levelOrder(TreeUtils.LevelBuildTree(nodes))));
    }
}
