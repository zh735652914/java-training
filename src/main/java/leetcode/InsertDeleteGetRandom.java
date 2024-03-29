package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
380. Insert Delete GetRandom O(1)
Medium

1753

127

Add to List

Share
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
Accepted
169,419
Submissions
373,799
 */
class RandomizedSet {
    /**
     * Initialize your data structure here.
     */
    Random random;
    HashMap<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        return list.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        SwaptoLast(val);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    private void SwaptoLast(int x) {
        if (map.get(x) >= list.size() - 1) return;
        list.set(map.get(x), list.get(list.size() - 1));
        //这个地方是一个坑，需要更新map中值和地址的映射
        map.put(list.get(list.size() - 1), map.get(x));
        list.set(list.size() - 1, x);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

public class InsertDeleteGetRandom {
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

        // 2 was already in the set, so return false.
        randomSet.insert(2);

        // Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }

}
