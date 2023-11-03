package leetcode.programmerInterview;
/*
面试题 17.11. 单词距离
有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?

示例：

输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
输出：1
提示：

words.length <= 100000
通过次数6,002提交次数8,889
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//效率很低。。不过算是自己写出来了。。
public class findClosest {
    static class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
                list.add(i);
                map.put(words[i], list);
            }
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
//            int close1 = Math.abs(list1.get(0) - list2.get(list2.size() - 1));
//            int close2 = Math.abs(list1.get(list1.size() - 1) - list2.get(0));
//            return Math.min(close1, close2);
            int minClose = Integer.MAX_VALUE;
            for (Integer value : list1) {
                for (Integer integer : list2) {
                    if (minClose > Math.abs(value - integer)) {
                        minClose = Math.abs(value - integer);
                    }
                }
            }
            return minClose;
        }
    }

    public static void main(String[] args) {
        String[] wods = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "university", word2 = "student";
        System.out.println(new Solution().findClosest(wods, word1, word2));
    }
}
