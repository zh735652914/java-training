package beijing.hot100;

import java.util.HashMap;
import java.util.Map;

// 自己写的，效率的确不高
public class lRUCache_146 {
    static class LRUCache {
        private class Node {
            int val;
            int key;
            Node next;
            Node pre;

            Node(int val) {
                this.val = val;
            }
        }

        private final Map<Integer, Node> map;
        private final Node dummyHead;
        private final int capacity;

        public LRUCache(int capacity) {
            dummyHead = new Node(-1);
            this.capacity = capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            int val = -1;
            if (map.containsKey(key)) {
                Node node = map.get(key);
                val = node.val;
                moveNodeFirst(node);
            }
            return val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                moveNodeFirst(node);
                return;
            } else if (map.size() >= capacity) {
                Node p = dummyHead;
                while (p.next != null) {
                    p = p.next;
                }
                map.remove(p.key);
                deleteNode(p);
            }
            Node node = new Node(value);
            node.key = key;
            moveNodeFirst(node);
            map.put(key, node);
        }

        private void deleteNode(Node node) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
        }

        private void moveNodeFirst(Node node) {
            deleteNode(node);
            Node next = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;
            node.next = next;
            if (next != null) {
                next.pre = node;
            }
        }
    }

    public static void main(String[] args) {
        String[] ops = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] nums = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        LRUCache lRUCache = new LRUCache(nums[0][0]);
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "put":
                    lRUCache.put(nums[i][0], nums[i][1]);
                    break;
                case "get":
                    System.out.println(lRUCache.get(nums[i][0]));
                    break;
            }
        }
    }
}
