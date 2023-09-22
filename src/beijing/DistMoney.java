package beijing;

/**
 * @author zhouhao
 * @date 2023/9/22 19:49
 */
public class DistMoney {
    // 简单题自己都不会写了
    static class Solution {
        public int distMoney(int money, int children) {
            if (money < children) {
                return -1;
            }
            money -= children;
            int ans = Math.min(money / 7, children);
            money -= ans * 7;
            children -= ans;
            if (money > 0 && children == 0 || money == 3 && children == 1) {
                ans--;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int money = 20, children = 3;
        System.out.println(new Solution().distMoney(money, children));
    }
}
