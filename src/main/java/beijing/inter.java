package beijing;

import java.util.ArrayList;
import java.util.List;

public class inter {
    static class solution {
        public List<List<Integer>> solution0(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > target) {
                    break;
                }
                while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
                int sumTarget = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sumTarget) {
                        List<Integer> aPir = new ArrayList<>();
                        aPir.add(nums[i]);
                        aPir.add(nums[left]);
                        aPir.add(nums[right]);
                        ans.add(aPir);
                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;// 1     2 3 7 7 7 7
                    } else if (nums[left] + nums[right] < sumTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        int target = 15;
        System.out.println(new solution().solution0(nums, target));
    }
}
