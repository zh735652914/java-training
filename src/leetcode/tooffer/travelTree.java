package leetcode.tooffer;

import java.util.ArrayList;
import java.util.List;

public class travelTree {

    public void levelTree(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        System.out.println(levelVisit(root, 0, levelList));
    }

    private List<List<Integer>> levelVisit(TreeNode node, int deep, List<List<Integer>> levelList) {
        if (node == null) return levelList;
        if (levelList.size() <= deep) {
            List<Integer> alevel = new ArrayList<>();
            alevel.add(node.val);
            levelList.add(alevel);
        } else {
            levelList.get(deep).add(node.val);
        }
        levelVisit(node.left, deep + 1, levelList);
        levelVisit(node.right, deep + 1, levelList);
        return levelList;
    }
}
