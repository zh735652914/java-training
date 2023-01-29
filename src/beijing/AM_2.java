package beijing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AM_2 {
    static int N;
    static Set<Integer> hasVisited;
    static Node findRoot = new Node(0);
    static Map<Integer, Node> map;

    static class Node {
        int val;
        List<Node> next;
        List<Node> pre;

        Node(int val) {
            val = this.val;
            next = new ArrayList<>();
            pre = new ArrayList<>();
        }
    }

    public static boolean check() {
        // 从0节点开始
        hasVisited = new HashSet<>();
        backtrack(findRoot);
        return hasVisited.size() == N;
    }

    private static void backtrack(Node root) {
        if (hasVisited.size() == N) {
            return;
        }
        if (hasVisited.contains(root.val)) {
            return;
        }
        hasVisited.add(root.val);

        List<Node> next = root.next;
        for (Node node : next) {
            backtrack(node);
        }
    }

    public static void mkConnection(int x, int y) {
        Node xNode, yNode;
        if (map.containsKey(x)) {
            xNode = map.get(x);
        } else {
            xNode = new Node(x);
            map.put(x, xNode);
        }
        if (map.containsKey(y)) {
            yNode = map.get(y);
        } else {
            yNode = new Node(y);
            map.put(y, yNode);
        }
        if (!xNode.next.contains(yNode)) {
            xNode.next.add(yNode);
            xNode.pre.add(yNode);
            yNode.next.add(xNode);
            yNode.pre.add(xNode);
        }
        System.out.println("ddd");
    }

    public static void main(String[] args) {
        // N = 7
        // log = [[0,1,1], [2,3,3], [5,6,7], [3,4,9], [1,2,10], [4,6,12], [3,5,16]]
        N = 7;
        int[][] logs = {{0, 1, 1}, {2, 3, 3}, {5, 6, 7}, {3, 4, 9}, {1, 2, 0}, {4, 6, 12}, {3, 5, 16}};
        map = new HashMap<>();
        map.put(0, findRoot);
        for (int[] log : logs) {
            mkConnection(log[0], log[1]);
            if (check()) {
                System.out.println(log[2]);
            }
            System.out.println(hasVisited.size());
        }
    }
}
