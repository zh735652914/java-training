package LeetCode.ProgrammerInterview;
/*
设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。

示例 1:

输入: nums = [5,6,5], target = 11
输出: [[5,6]]
示例 2:

输入: nums = [5,6,5,6], target = 11
输出: [[5,6],[5,6]]
提示：

nums.length <= 100000
通过次数4,435提交次数9,666

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//hashmap效率有点低。。。
public class pairSums {
    static class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int num : nums) {
                if (hasNum(num, map) && hasNum(target - num, map)) {
                    List<Integer> aPair = new ArrayList<>(2);
                    aPair.add(num);
                    aPair.add(target - num);
                    ans.add(aPair);
                }
            }
            return ans;
        }

        private boolean hasNum(int target, Map<Integer, Integer> map) {
            if (map.getOrDefault(target, 0) > 0) {
                map.put(target, map.get(target) - 1);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 5, 6};
        int target = 11;
        System.out.println(new Solution().pairSums(nums, target));
    }
}
