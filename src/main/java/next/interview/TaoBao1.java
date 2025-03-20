package next.interview;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/20 21:08
 */
public class TaoBao1 {
    public String func(String s) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isUpperCase(s.charAt(i))) {
                int start = i++;
                while (i < s.length() && Character.isLowerCase(s.charAt(i))) i++;
                String word = s.substring(start, i);
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + s.charAt(i++) - '0';
                }
                count = Math.max(1, count);
                currentMap.put(word, currentMap.getOrDefault(word, 0) + count);
            } else if (s.charAt(i) == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (s.charAt(i) == ')') {
                i++;
                int repeat = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    repeat = repeat * 10 + s.charAt(i++) - '0';
                }
                repeat = Math.max(1, repeat);
                Map<String, Integer> parentMap = stack.pop();
                multiply(currentMap, repeat);
                mergeMaps(parentMap, currentMap);
                currentMap = parentMap;
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(currentMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }

    private void mergeMaps(Map<String, Integer> dest, Map<String, Integer> src) {
        for (Map.Entry<String, Integer> entry : src.entrySet()) {
            dest.put(entry.getKey(), dest.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private void multiply(Map<String, Integer> map, int multiplier) {
        for (String key : new ArrayList<>(map.keySet())) {
            map.put(key, map.get(key) * multiplier);
        }
    }


    @Test
    public void test() {
        String input = "World3Hello";
        assertEquals("HelloWorld3", func(input));
        System.out.println(func(input));
    }

    @Test
    public void test2() {
        String input = "Welcome4(ToAlibaba(To3)2)2";
        assertEquals("Alibaba2To14Welcome4", func(input));
        System.out.println(func(input));
    }

}
