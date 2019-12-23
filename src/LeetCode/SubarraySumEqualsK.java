package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
560. Subarray Sum Equals K
Medium

2895

78

Add to List

Share
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
//自己不会写，依旧感觉自己是个智障。。。
class SubarraySumEqualsKSolution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new SubarraySumEqualsKSolution().subarraySum(nums, k));
    }
}
