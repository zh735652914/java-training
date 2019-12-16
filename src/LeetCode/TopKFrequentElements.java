package LeetCode;

import java.util.*;

/*
347. Top K Frequent Elements
Medium

2111

140

Favorite

Share
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
//不会写，看了Discuss感觉很牛逼
class TopKFrequentElementsSolution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new LinkedList<>();
            }
            bucket[map.get(key)].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                ans.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return ans;
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(new TopKFrequentElementsSolution().topKFrequent(nums, k));
    }
}
