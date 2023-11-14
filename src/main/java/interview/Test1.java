package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 滴滴一面
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value
 * 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author zhouhao
 * @date 2023/11/14 19:38
 */
public class Test1 {
    class LinkNode {
        int key;
        int value;
        LinkNode pre;
        LinkNode next;

        public LinkNode() {

        }

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, LinkNode> map = new HashMap<>();
    private final int capacity;
    private int size;
    private final LinkNode head;
    private final LinkNode tail;

    public Test1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LinkNode node = map.get(key);
        moveTohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            LinkNode cur = new LinkNode(key, value);
            map.put(key, cur);
            addHead(cur);
            size++;
            if (size > capacity) {
                removeLastNode();
                size--;
            }
        } else {
            moveTohead(map.get(key));
        }
    }

    private void removeLastNode() {
        map.remove(tail.pre.key);
        remove(tail.pre);
    }

    private void moveTohead(LinkNode node) {
        remove(node);
        addHead(node);
    }

    private void remove(LinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addHead(LinkNode node) {
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }


    public static void main(String[] args) {
        //解释
        Test1 lRUCache = new Test1(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));   // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
