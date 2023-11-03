package leetcode.programmerInterview;
/*
面试题 17.18. 最短超串
假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。

返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。

示例 1:

输入:
big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
small = [1,5,9]
输出: [7,10]
示例 2:

输入:
big = [1,2,3]
small = [4]
输出: []
提示：

big.length <= 100000
1 <= small.length <= 100000
通过次数2,635提交次数5,994
 */


import java.util.HashMap;
import java.util.Map;

public class shortestSeq {
    static class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            if (small.length > big.length) {
                return new int[]{};
            }
            Map<Integer, Integer> map = new HashMap<>();
            int count = small.length;
            int[] ans = {0, big.length - 1};
            for (int x : small) {
                map.put(x, -1);
            }
            for (int i = 0; i < big.length; i++) {
                if (map.containsKey(big[i])) {
                    if (map.get(big[i]) == -1) {
                        count--;
                    }
                    map.put(big[i], i);
                }
                if (count <= 0) {
                    makeAns(ans, map);
                }
            }
            return count <= 0 ? ans : new int[]{};
        }

        private void makeAns(int[] ans, Map<Integer, Integer> map) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int x : map.values()) {
                if (x > max) {
                    max = x;
                }
                if (x < min) {
                    min = x;
                }
            }
            if (max - min < ans[1] - ans[0]) {
                ans[0] = min;
                ans[1] = max;
            }
        }
    }

    public static void main(String[] args) {
        int[] big = {521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155};
        int[] small = {897261, 9385, 381783, 496153};
        int[] ans = new Solution().shortestSeq(big, small);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
