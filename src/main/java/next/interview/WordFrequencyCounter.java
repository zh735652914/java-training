package next.interview;

import java.util.*;

/**
 * @author zhouhao
 * @date 2025/3/20 21:31
 */
/*
// 1.单词统计（必做题）

// 给定一个字符串，计算字符串中每个单词出现的数量，并排序输出。

// a. 单词一个大写字母开始，接着跟随0个或任意个小写字母；

// b. 如果单词数量大于 1，单词后会跟着数字表示单词的数量。如果数量等于 1 则不会跟数字。例如，Hello2World 和 是合法，但 Hello1World2 这个表达是不合法的；

// c. Hello2表示HelloHello；

// d. (Hello2World2)3 可以等于Hello2World2Hello2World2Hello2World2；

// 输出格式为：第一个（按字典序）单词，跟着它的数量（如果单词数量为1，则不输出），然后是第二个单词的名字（按字典序），跟着它的数量（如果单词数量为1，则不输出），以此类推。

// 示例1：

// 输入：字符串 = "World3Hello"

// 输出: "HelloWorld3"

// 解释: 单词数量是 {'Hello': 1, 'World': 3}。

// 示例 2:

// 输入: 字符串 = "Welcome4(ToAlibaba(To3)2)2"

// 输出: "Alibaba2To14Welcome4"

// 解释: 单词数量是 {'Alibaba': 2,  'To': 14', Welcome': 4}。

// 注意:

// 字符串的长度在[1, 100000]之间。

// 字符串只包含字母、数字和圆括号，并且题目中给定的都是合法的字符串。
 */
public class WordFrequencyCounter {
    //    private static String func(String input) {
//        Map<String, Integer> wordCount = new HashMap<>();
//        Stack<Integer> multiplierStack = new Stack<>();
//        multiplierStack.push(1);
//
//        StringBuilder currentWord = new StringBuilder();
//        int i = 0;
//        while (i < input.length()) {
//            char ch = input.charAt(i);
//
//            if (Character.isUpperCase(ch)) {
//                // 如果当前有构建中的单词，则处理它
//                if (currentWord.length() > 0) {
//                    updateWordCount(wordCount, currentWord.toString(), multiplierStack.peek());
//                    currentWord.setLength(0); // 清空当前单词
//                }
//
//                currentWord.append(ch);
//            } else if (Character.isLowerCase(ch)) {
//                currentWord.append(ch);
//            } else if (Character.isDigit(ch)) {
//                int numStart = i;
//                while (i < input.length() && Character.isDigit(input.charAt(i))){
//                    i++;
//                }
//                int count = Integer.parseInt(input.substring(numStart, i--));
//
//                // 处理数字后的单词或括号内的内容
//                if (currentWord.length() > 0) {
//                    updateWordCount(wordCount, currentWord.toString(), count * multiplierStack.peek());
//                    currentWord.setLength(0);
//                } else {
//                    multiplierStack.push(count * multiplierStack.peek());
//                }
//            } else if (ch == '(') {
//                multiplierStack.push(multiplierStack.peek());
//            } else if (ch == ')') {
//                multiplierStack.pop();
//            }
//            i++;
//        }
//        // 处理最后的单词
//        if (currentWord.length() > 0) {
//            updateWordCount(wordCount, currentWord.toString(), multiplierStack.peek());
//        }
//
//        return formatOutput(wordCount);
//    }
//
//    private static void updateWordCount(Map<String, Integer> wordCount, String word, int multiplier) {
//        wordCount.put(word, wordCount.getOrDefault(word, 0) + multiplier);
//    }
//
//    /**
//     * 排序
//     * @param wordCount
//     * @return
//     */
//    private static String formatOutput(Map<String, Integer> wordCount) {
//        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
//        sortedEntries.sort(Map.Entry.comparingByKey());
//
//        StringBuilder result = new StringBuilder();
//        for (Map.Entry<String, Integer> entry : sortedEntries) {
//            result.append(entry.getKey());
//            if (entry.getValue() > 1) {
//                result.append(entry.getValue());
//            }
//        }
//
//        return result.toString();
//    }
    public static void main(String[] args) {
        String input = "Alibaba2To14Welcome4";
        System.out.println(processInput(input));
    }

    private static String processInput(String s) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
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
                multiplyAndMerge(currentMap, repeat);
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

    private static void multiplyAndMerge(Map<String, Integer> map, int multiplier) {
        for (String key : new ArrayList<>(map.keySet())) {
            map.put(key, map.get(key) * multiplier);
        }
    }

    private static void mergeMaps(Map<String, Integer> dest, Map<String, Integer> src) {
        for (Map.Entry<String, Integer> entry : src.entrySet()) {
            dest.put(entry.getKey(), dest.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
}
