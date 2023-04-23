package beijing;

/**
 * @author zhouhao
 * @date 2023/4/23 19:30
 */
public class t1 {
    /*
    1，2，4，3，5
     */

    private static int funchtion(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int leftMax = nums[0];
        int indexL = -1;
        for (int i = 0; i < nums.length; i++) {
            if (leftMax > nums[i]) {
                indexL = i;
            } else {
                leftMax = nums[i];
            }
        }
        if (indexL == -1) {
            return 0;
        }
        int indexR = -1;
        int minRight = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (minRight < nums[i]) {
                indexR = i;
            } else {
                minRight = nums[i];
            }
        }
        return indexL - indexR + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5};
//        int[] nums = {5, 3, 4, 2, 1};
        System.out.println(funchtion(nums));
    }
}
