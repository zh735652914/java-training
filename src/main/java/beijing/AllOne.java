package beijing;
/*
https://leetcode-cn.com/problems/all-oone-data-structure/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 这个可以写成LFU
public class AllOne {
    private final Map<String, Node> nodes;
    private final Node root;

    private class Node {
        int count;
        Node pre;
        Node next;
        Set<String> keys;

        public Node() {
            count = 0;
            keys = new HashSet<>();
        }

        public Node(int count, String key) {
            this.count = count;
            keys = new HashSet<>();
            keys.add(key);
        }

        // 删除当前结点
        public void removeNode() {
            this.pre.next = this.next;
            this.next.pre = pre;
        }

        // 在后面添加结点
        public void addNode(Node newNode) {
            Node next = this.next;
            this.next = newNode;
            newNode.pre = this;
            newNode.next = next;
            next.pre = newNode;
        }
    }

    public AllOne() {
        root = new Node();
        nodes = new HashMap<>();
        root.pre = root;
        root.next = root;
    }

    public void inc(String key) {
        if (nodes != null && nodes.containsKey(key)) {
            Node cur = nodes.get(key);
            cur.keys.remove(key);
            if (cur.next == root || cur.next.count > cur.count + 1) {
                Node newNode = new Node(cur.count + 1, key);
                cur.addNode(newNode);
                nodes.put(key, newNode);
            } else {
                cur.next.keys.add(key);
                nodes.put(key, cur.next);
            }
            if (cur.keys.size() == 0) {
                cur.removeNode();
            }
        } else {
            if (root.next == root || root.next.count > 1) {
                Node newNode = new Node(1, key);
                nodes.put(key, newNode);
                root.addNode(newNode);
            } else {
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
        if (!nodes.containsKey(key)) {
            return;
        }
        Node cur = nodes.get(key);
        cur.keys.remove(key);
        int count = cur.count - 1;
        if (count == 0) {
            nodes.remove(key);
            if (cur.keys.size() == 0) {
                cur.removeNode();
            }
            return;
        }
        Node pos;
        if (cur.pre == root || cur.pre.count < count) {
            pos = new Node(count, key);
            cur.pre.addNode(pos);
        } else {
            cur.pre.keys.add(key);
            pos = cur.pre;
        }
        nodes.put(key, pos);
        if (cur.keys.size() == 0) {
            cur.removeNode();
        }
    }

    public String getMaxKey() {
        return root.pre.count == 0 ? "" : root.pre.keys.iterator().next();
    }

    public String getMinKey() {
        return root.next.count == 0 ? "" : root.next.keys.iterator().next();
    }

    public static void main(String[] args) {
        String[] ops = {"AllOne", "inc", "inc", "inc", "inc", "inc", "inc", "dec", "dec", "getMinKey", "dec", "getMaxKey", "getMinKey"};
        String[][] data = {{}, {"a"}, {"b"}, {"b"}, {"c"}, {"c"}, {"c"}, {"b"}, {"b"}, {}, {"a"}, {}, {}};
//        String[] ops = {"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"};
//        String[][] data = {{}, {"hello"}, {"hello"}, {}, {}, {"leet"}, {}, {}};
        AllOne allOne = new AllOne();
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "inc":
                    allOne.inc(data[i][0]);
                    break;
                case "dec":
                    allOne.dec(data[i][0]);
                    break;
                case "getMaxKey":
                    System.out.println(allOne.getMaxKey());
                    break;
                case "getMinKey":
                    System.out.println(allOne.getMinKey());
                    break;
            }
        }
    }
}
