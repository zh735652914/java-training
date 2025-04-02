package next.interview;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/2 19:44
 */
public class Ali {
//    public int func(String s, int k) {
//        if (s == null || s.length() < k) {
//            return 0;
//        }
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
//        }
//        List<Integer> splitIndex = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (countMap.get(ch) < k) {
//                splitIndex.add(i);
//            }
//        }
//        int maxLen = 0;
//        int lastIndex = 0;
//        for (int index : splitIndex) {
//            maxLen = Math.max(maxLen, index - lastIndex);
//            lastIndex = index;
//        }
//        return maxLen;
//    }

    public int func(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (countMap.get(ch) < k) {
                int j = i + 1;
                while (j < s.length() && countMap.get(s.charAt(j)) < k) {
                    j++;
                }
                return Math.max(func(s.substring(0, i), k), func(s.substring(j), k));
            }
        }
        return s.length();
    }

    @Test
    public void test() {
        String s = "aaabb";
        int k = 3;
        assertEquals(3, func(s, k));
    }

    @Test
    public void test1() {
        String s = "acbabb";
        int k = 2;
        assertEquals(2, func(s, k));
    }

    @Test
    public void test2() {
        String s = "abc";
        int k = 1;
        assertEquals(3, func(s, k));
    }

    @Test
    public void test3() {
        String s = "aaaa";
        int k = 4;
        assertEquals(4, func(s, k));
    }

    @Test
    public void test4() {
        String s = "abac";
        int k = 2;
        assertEquals(0, func(s, k));
    }
}
