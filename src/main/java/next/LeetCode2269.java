package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/10 08:33
 * https://leetcode.cn/problems/find-the-k-beauty-of-a-number/?envType=daily-question&envId=2025-03-10
 */
public class LeetCode2269 {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            int x = Integer.parseInt(str.substring(i, i + k));
            if (x == 0) {
                continue;
            }
            if ((num / x) * x == num) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int num = 240, k = 2;
        System.out.println(divisorSubstrings(num, k));
    }
}
