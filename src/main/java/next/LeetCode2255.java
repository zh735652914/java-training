package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/24 08:13
 */
public class LeetCode2255 {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }
            if (s.startsWith(word)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        assertEquals(3, countPrefixes(words, s));
    }
}
