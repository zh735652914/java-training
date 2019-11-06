package LeetCode;

//java前序中序建立一颗二叉树
public class BuildTree {
    public TreeNode Build(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len1 = preorder.length - 1, len2 = inorder.length - 1;
        if (len1 != len2) return null;
        return dfs(preorder, inorder, 0, len2, 0);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int low, int high, int index) {
        if (low > high) return null;
        TreeNode node = new TreeNode(preorder[index]);
        if (low == high) return node;
        int pos = searchInsert(inorder, preorder[index], low, high);
        node.left = dfs(preorder, inorder, low, pos - 1, index + 1);
        node.right = dfs(preorder, inorder, pos + 1, high, index + 1 + (pos - low));
        return node;
    }

    private int searchInsert(int[] nums, int t, int low, int high) {
        int pos = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == t) {
                pos = i;
                break;
            }
        }
        return pos;
    }


    public TreeNode LevelBuild(String[] s) {
        TreeNode[] nodes = new TreeNode[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("null")) continue;
            nodes[i] = new TreeNode(Integer.parseInt(s[i]));
        }
        int[] insert = new int[s.length];
        LevelBacktrack(nodes, 1);
        return nodes[0];
    }

    private void LevelBacktrack(TreeNode[] nodes, int level) {

        int lastlevel = level - 1;
        int rootStart = (int) (Math.pow(2, lastlevel) - 1), nodeStart = (int) (Math.pow(2, level) - 1);

        int index = nodeStart;
        int flag = 1;
        for (int i = rootStart; i < nodeStart && i < nodes.length; i++) {
            if (index >= nodes.length) {
                flag = 0;
                break;
            }
            nodes[i].left = nodes[index];
            index++;
            if (index >= nodes.length) {
                flag = 0;
                break;
            }
            nodes[i].right = nodes[index];
            index++;
        }
        if (flag == 1) LevelBacktrack(nodes, level + 1);
    }
}
