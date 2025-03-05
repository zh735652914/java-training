package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/5 08:49
 * https://leetcode.cn/problems/3sum/
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    List<Integer> find = new ArrayList<>();
                    find.add(nums[i]);
                    find.add(nums[left]);
                    find.add(nums[right]);
                    ans.add(find);
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
//                    while (right > left && nums[right] == nums[right - 1]) {
//                        right--;
//                    }
//                    right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
