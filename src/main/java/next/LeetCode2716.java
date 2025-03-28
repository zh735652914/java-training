package next;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/28 08:28
 * https://leetcode.cn/problems/minimize-string-length/?envType=daily-question&envId=2025-03-28
 */
public class LeetCode2716 {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }

    @Test
    public void test() {
        String s = "aaabc";
        assertEquals(3, minimizedStringLength(s));
    }
}
