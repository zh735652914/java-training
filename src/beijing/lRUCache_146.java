package beijing;

import java.util.HashMap;
import java.util.Map;

// 排查起来太累了
public class lRUCache_146 {
    static class LRUCache {
        class DNode {
            int val;
            int key;
            DNode pre;
            DNode next;

            DNode(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }

        private final DNode dummyHead;
        private DNode tail;
        private final Map<Integer, DNode> map;
        public int capacity;

        private DNode addNodeFirst(int key, int val) {
            if (map.containsKey(key)) {
                rmNode(map.get(key));
            }
            DNode cur = new DNode(key, val);
            cur.next = dummyHead.next;
            if (dummyHead.next != null) {
                dummyHead.next.pre = cur;
            } else {
                tail = cur;
            }
            cur.pre = dummyHead;
            dummyHead.next = cur;
            return cur;
        }

        private void rmNode(DNode node) {
            DNode before = node.pre;
            before.next = node.next;
            if (node == tail) {
                tail = before;
            } else {
                node.next.pre = before;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            dummyHead = new DNode(-1, -1);
            tail = dummyHead;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            map.put(key, addNodeFirst(key, val));
            return val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, addNodeFirst(key, value));
                return;
            }
            while (map.size() >= capacity) {
                map.remove(tail.key);
                rmNode(tail);
            }
            map.put(key, addNodeFirst(key, value));
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(4));    // return -1 (not found)
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));    // return 3
        System.out.println(lRUCache.get(1));    // return 4
        lRUCache.put(5, 5);
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));
    }
}
