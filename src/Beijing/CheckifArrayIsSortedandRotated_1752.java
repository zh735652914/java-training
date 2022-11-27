package Beijing;

/**
 * @author zhouhao
 * @date 2022/11/27 15:03
 */
public class CheckifArrayIsSortedandRotated_1752 {
    // 自己居然没想到怎么写
    static class Solution {
        public boolean check(int[] nums) {
            boolean flag = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (flag) {
                        return false;
                    }
                    flag = true;
                }
            }
            return !flag || nums[0] >= nums[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        System.out.println(new Solution().check(nums));
    }
}
