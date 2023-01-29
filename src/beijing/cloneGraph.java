package beijing;
/*
https://leetcode-cn.com/problems/clone-graph/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class cloneGraph {
    static class Solution {
        Map<Integer, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node.val)) {
                return map.get(node.val);
            }
            Node cp = new Node(node.val);
            map.put(node.val, cp);
            for (int i = 0; i < node.neighbors.size(); i++) {
                cp.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
            return cp;
        }
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            nodes.add(new Node(i + 1));
        }
        for (int i = 0; i < adjList.length; i++) {
            nodes.get(i).neighbors.add(nodes.get(adjList[i][0] - 1));
            nodes.get(i).neighbors.add(nodes.get(adjList[i][1] - 1));
        }
        Node CpNode = new Solution().cloneGraph(nodes.get(0));
        Map<Integer, Node> map = new HashMap<>();
        visit(CpNode, map);
        Iterator<Map.Entry<Integer, Node>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Node> entry = iterator.next();
            for (int i = 0; i < entry.getValue().neighbors.size(); i++) {
                System.out.print(entry.getValue().neighbors.get(i).val + ", ");
            }
            System.out.println();
        }
    }

    private static void visit(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return;
        }
        map.put(node.val, node);
        for (int i = 0; i < node.neighbors.size(); i++) {
            visit(node.neighbors.get(i), map);
        }
    }
}
