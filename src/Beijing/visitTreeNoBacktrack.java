package Beijing;

import java.util.*;

public class visitTreeNoBacktrack {
    protected List<Integer> postVisitTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> seen = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null && seen.contains(stack.peek())) {
                ans.add(stack.pop().val);
            } else if (root == null) {
                seen.add(stack.peek());
                root = stack.peek().right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4", "5", "6", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new visitTreeNoBacktrack().postVisitTree(root));
    }
}
