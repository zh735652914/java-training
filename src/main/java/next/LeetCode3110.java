package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/15 08:38
 * https://leetcode.cn/problems/score-of-a-string/description/?envType=daily-question&envId=2025-03-15
 */
public class LeetCode3110 {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }

    @Test
    public void test() {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }
}
