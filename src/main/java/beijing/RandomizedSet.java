package beijing;
/*
https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */

import java.util.*;

// 自己没写出来，情况得多注意一下
public class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final Random random;
    private final List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        String[] ops = {"insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"};
        int[][] nums = {{1}, {2}, {2}, {}, {1}, {2}, {}};
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "insert":
                    System.out.println(randomizedSet.insert(nums[i][0]));
                    break;
                case "remove":
                    System.out.println(randomizedSet.remove(nums[i][0]));
                    break;
                case "getRandom":
                    System.out.println(randomizedSet.getRandom());
                    break;
            }
        }
    }
}
