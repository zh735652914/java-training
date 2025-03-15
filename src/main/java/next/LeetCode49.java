package next;

import org.junit.Test;

import java.util.*;

/**
 * @author zhouhao
 * @date 2025/3/15 21:00
 * https://leetcode.cn/problems/group-anagrams/
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
