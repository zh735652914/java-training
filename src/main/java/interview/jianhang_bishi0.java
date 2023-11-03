package interview;

import java.util.Arrays;

public class jianhang_bishi0 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param cars int整型一维数组 车辆数量
         * @param num  int整型 出游总人数
         * @return int整型
         */
        int ans;

        public int carsTrans(int[] cars, int num) {
            Arrays.sort(cars);
            int index = cars.length - 1;
            ans = Integer.MAX_VALUE;
            dfs(cars, num, index, 0);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private void dfs(int[] cars, int num, int index, int count) {
            if (num == 0) {
                ans = Math.min(ans, count);
                return;
            }
            while (num > 0 && index >= 0) {
                while (cars[index] <= num) {
                    dfs(cars, num - cars[index], index - 1, count + 1);
                    num -= cars[index];
                    count++;
                }
                index--;
            }
            if (num == 0) {
                ans = Math.min(ans, count);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6};
        int num = 15;
//        int[] nums = {1, 2, 5};
//        int num = 11;
        System.out.println(new Solution().carsTrans(nums, num));
    }
}
