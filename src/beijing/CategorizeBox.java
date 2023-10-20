package beijing;
/*
https://leetcode.cn/problems/categorize-box-according-to-criteria/?envType=daily-question&envId=2023-10-20
 */

/**
 * @author zhouhao
 * @date 2023/10/20 12:22
 */
public class CategorizeBox {
    // 很简单的题
    static class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            boolean bulky = isBulky(length, width, height, mass);
            boolean heavy = isHeavy(mass);
            if (bulky && heavy) {
                return "Both";
            } else if (!bulky && !heavy) {
                return "Neither";
            } else if (bulky) {
                return "Bulky";
            } else {
                return "Heavy";
            }
        }

        private boolean isBulky(int length, int width, int height, int mass) {
            int x = 10000;
            long y = 1000000000;
            if (length >= x || width >= x || height >= x || mass >= x) {
                return true;
            }
            return (long) length * (long) width * (long) height >= y;
        }

        private boolean isHeavy(int mass) {
            return mass >= 100;
        }
    }

    public static void main(String[] args) {
        int length = 1000, width = 35, height = 700, mass = 300;
        System.out.println(new Solution().categorizeBox(length, width, height, mass));
        System.out.println(Integer.MAX_VALUE);
    }
}
