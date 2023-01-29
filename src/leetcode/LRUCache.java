package leetcode;
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?
*/
//Example:

//LRUCache cache = new LRUCache( 2 /* capacity */ )
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LRUCacheSolution {
    static int capacity = 0;
    static HashMap<Integer, Integer> cache = new HashMap<>();
    static List<Integer> user = new LinkedList<>();

    public LRUCacheSolution(int capacity) {
        LRUCacheSolution.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        user.remove((Integer) key);
        user.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
//        if (cache.size() == capacity) {
//            int rmkey = user.get(0);
//            user.remove(0);
//            cache.remove(rmkey);
//        }
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            user.remove((Integer) key);
            user.add(key);
        } else {
            if (cache.size() == capacity) {
                int rmkey = user.get(0);
                user.remove(0);
                cache.remove(rmkey);
            }
            cache.put(key, value);
            user.add(key);
        }
    }
}

public class LRUCache {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCacheSolution cache = new LRUCacheSolution(capacity);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));   // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));   // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));   // returns -1 (not found)
//        System.out.println(cache.get(3));   // returns 3
//        System.out.println(cache.get(4));   // returns 4


        System.out.println(cache.get(2));   // returns -1 (not found)
        cache.put(2, 6);
        System.out.println(cache.get(1));   // returns -1 (not found)
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));   // returns 2
        System.out.println(cache.get(2));   // returns 6
    }
}
