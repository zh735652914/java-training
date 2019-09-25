package LeetCode;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
class TrappingRainWaterSolution {
    int ans = 0;

    public int trap(int[] height) {
        backtrack(height, 0, height.length - 1);
        return ans;
    }

    private void backtrack(int[] height, int L, int R) {
        if ((L + 1) >= R) return;
        int max = height[L + 1];
        int pos = L + 1;
        for (int i = L + 1; i < R; i++) {
            if (height[i] > max) {
                max = height[i];
                pos = i;
            }
        }
        if (max < height[L] && max < height[R]) {
            int H = Math.min(height[L], height[R]);
            for (int i = L + 1; i < R; i++) {
                ans += H - height[i];
            }
        } else if (max < height[L] && (pos == R - 1)) {
            backtrack(height, L, pos);
        } else if (max < height[R] && (pos == L + 1)) {
            backtrack(height, pos, R);
        } else {
            backtrack(height, L, pos);
            backtrack(height, pos, R);
        }
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {2, 1, 2, 1};
        TrappingRainWaterSolution TRWS = new TrappingRainWaterSolution();
        System.out.println(TRWS.trap(height));
    }
}
