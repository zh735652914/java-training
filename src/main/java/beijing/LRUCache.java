package beijing;
/*
https://leetcode-cn.com/problems/lru-cache/
 */

import java.util.LinkedHashMap;
import java.util.Map;

// 这个方法写起来简单，但是需要阅读源码
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        String[] ops = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] nums = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
//        String[] ops = {"LRUCache", "get", "put", "get", "put", "put", "get", "get"};
//        int[][] nums = {{2}, {2}, {2, 6}, {1}, {1, 5}, {1, 2}, {1}, {2}};
        LRUCache LRU = null;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "LRUCache":
                    LRU = new LRUCache(nums[i][0]);
                    System.out.println("null");
                    break;
                case "put":
                    LRU.put(nums[i][0], nums[i][1]);
                    System.out.println("null");
                    break;
                case "get":
                    System.out.println(LRU.get(nums[i][0]));
                    break;
            }
        }
    }
}

// 这个是自己写的，但是效率不太高
//public class LRUCache {
//    private Map<Integer, int[]> map;
//    private List<int[]> list;
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        map = new HashMap<>(capacity);
//        list = new LinkedList<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        int x = map.get(key)[1];
//        list.remove(map.get(key));
//        list.add(0, map.get(key));
//        return x;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            list.remove(map.get(key));
//            map.get(key)[1] = value;
//            list.add(0, map.get(key));
//        } else {
//            if (map.size() >= capacity) {
//                map.remove(list.get(list.size() - 1)[0]);
//                list.remove(list.size() - 1);
//            }
//            int[] V = new int[]{key, value};
//            list.add(0, V);
//            map.put(key, V);
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] ops = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
//        int[][] nums = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
////        String[] ops = {"LRUCache", "get", "put", "get", "put", "put", "get", "get"};
////        int[][] nums = {{2}, {2}, {2, 6}, {1}, {1, 5}, {1, 2}, {1}, {2}};
//        LRUCache LRU = null;
//        for (int i = 0; i < ops.length; i++) {
//            switch (ops[i]) {
//                case "LRUCache":
//                    LRU = new LRUCache(nums[i][0]);
//                    System.out.println("null");
//                    break;
//                case "put":
//                    LRU.put(nums[i][0], nums[i][1]);
//                    System.out.println("null");
//                    break;
//                case "get":
//                    System.out.println(LRU.get(nums[i][0]));
//                    break;
//            }
//        }
//    }
//}
