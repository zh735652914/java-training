package beijing;

/**
 * @author zhouhao
 * @date 2023/10/25 12:20
 */
public class PunishmentNumber {
    // 这个dfs需要看看
    static class Solution {
        public int punishmentNumber(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (dfs(String.valueOf(i * i), 0, 0, i)) {
                    ans += i * i;
                }
            }
            return ans;
        }

        private boolean dfs(String s, int pos, int sumCount, int target) {
            if (pos == s.length()) {
                return sumCount == target;
            }
            int sum = 0;
            for (int i = pos; i < s.length(); i++) {
                sum = sum * 10 + s.charAt(i) - '0';
                if (sum + sumCount > target) {
                    break;
                }
                if (dfs(s, i + 1, sumCount + sum, target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().punishmentNumber(n));
    }
}
