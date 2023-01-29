package beijing;
/*
https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 */

import java.util.LinkedList;
import java.util.List;

public class countHighestScoreNodes {
    static class Solution {
        private List<Integer>[] children;
        private int count;
        private long Maxscore; //必须是long
        private int len;

        public int countHighestScoreNodes(int[] parents) {
            children = new List[parents.length];
            count = 1;
            len = parents.length;
            for (int i = 0; i < children.length; i++) {
                children[i] = new LinkedList<>();
            }
            for (int i = 0; i < parents.length; i++) {
                if (parents[i] != -1) {
                    children[parents[i]].add(i);
                }
            }
            dfs(0);
            return count;
        }

        private int dfs(int node) {
            long score = 1;
            int nodeCount = 1;
            for (int chlid : children[node]) {
                int num = dfs(chlid);
                score *= num;
                nodeCount += num;
            }
            if (node != 0) {
                score *= len - nodeCount;
            }
            if (score == Maxscore) {
                count++;
            } else if (score > Maxscore) {
                Maxscore = score;
                count = 1;
            }
            return nodeCount;
        }
    }

    public static void main(String[] args) {
        int[] parents = {-1, 2, 0, 2, 0};
        System.out.println(new Solution().countHighestScoreNodes(parents));
    }
}
