package Beijing;
/*
https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// 不是自己写的，自己不会
public class randomPointinNonoverlappingRectangles_497 {
    static class Solution {
        Random random;
        List<Integer> list;
        int[][] rects;

        public Solution(int[][] rects) {
            this.rects = rects;
            list = new ArrayList<>();
            list.add(0);
            random = new Random();
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                // 获取所有点, 如果有2 个矩形, 那么第二个矩形应该包含第一个矩形中的所有点
                list.add(list.get(list.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            // 在最后一个矩形包含的 点 中随机取一个点
            int k = random.nextInt(list.get(list.size() - 1));
            // 找到矩形的编号
            int rectIndex = binarySearch(list, k + 1) - 1;
            // 找到随机值 k 在 对应矩形中的编号
            k -= list.get(rectIndex);
            // 获取左下角的值跟右上角的值
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            // 还原索引
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        List<int[]> ans = new ArrayList<>();
        ans.add(solution.pick()); // 返回 [1, -2]
        ans.add(solution.pick()); // 返回 [1, -1]
        ans.add(solution.pick()); // 返回 [-1, -2]
        ans.add(solution.pick()); // 返回 [-2, -2]
        ans.add(solution.pick()); // 返回 [0, 0]
        for (int[] x : ans) {
            System.out.println(x[0] + ", " + x[1]);
        }
    }
}
