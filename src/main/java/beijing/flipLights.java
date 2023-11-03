package beijing;
/*
https://leetcode.cn/problems/bulb-switcher-ii/
 */

public class flipLights {
    // 自己不会写，这个归纳有点复杂
    static class Solution {
        public int flipLights(int n, int presses) {
            //不按开关
            if (presses == 0) {
                return 1;
            }
            //特殊情况处理
            if (n == 1) {
                return 2;
            } else if (n == 2) {
                //特殊情况
                return presses == 1 ? 3 : 4;
            } else {
                //n >= 3
                return presses == 1 ? 4 : presses == 2 ? 7 : 8;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1, presses = 1;
        System.out.println(new Solution().flipLights(n, presses));
    }
}
