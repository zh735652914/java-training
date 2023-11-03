package leetcode.programmerInterview;
/*
面试题 17.22. 单词转换
给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。

编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。

示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
["hit","hot","dot","lot","log","cog"]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
通过次数3,515提交次数10,137
 */

import java.util.*;

public class findLadders {
    static class Solution {
        List<String> wordList;
        boolean[] marked;
        List<String> output;
        String endWord;
        List<String> result;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            this.wordList = wordList;
            output = new ArrayList();
            marked = new boolean[wordList.size()];
            result = new ArrayList();
            this.endWord = endWord;
            dfs(beginWord);
            return result;
        }

        public void dfs(String s) {
            output.add(s);
            Queue<String> queue = oneCharDiff(s);
            for (String str : queue) {
                if (str.equals(endWord)) {
                    output.add(str);
                    result = new ArrayList(output);
                    return;
                }
                dfs(str);
                output.remove(output.size() - 1);
            }

        }

        public Queue<String> oneCharDiff(String s) {
            Queue<String> queue = new LinkedList();
            for (int j = 0; j < wordList.size(); j++) {
                String str = wordList.get(j);
                int diffNum = 0;
                if (str.length() != s.length() || marked[j]) continue;
                for (int i = 0; i < str.length(); i++) {
                    if (diffNum >= 2) break;
                    if (str.charAt(i) != s.charAt(i)) diffNum++;
                }
                if (diffNum == 1) {
                    queue.add(str);
                    marked[j] = true;
                }
            }
            return queue;
        }
    }

    //自己写的超时了
    static class Solution0 {
        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return new ArrayList<>();
            }
            for (int i = 0; i < beginWord.length(); i++) {
                List<String> tmp = dfs(beginWord, endWord, wordList, new ArrayList<>(), i);
                if (tmp.size() != 0) {
                    return tmp;
                }
            }
            return new ArrayList<>();
        }

        private List<String> dfs(String word, String endWord, List<String> wordList, List<String> ans, int pos) {
            ans.add(word);
            if (word.equals(endWord)) {
                return ans;
            }
            if (pos == word.length()) {
                return new ArrayList<>();
            }
            StringBuilder wordBuilder = new StringBuilder(word.substring(0, pos));
            for (int i = 0; i < 26; i++) {
                char change = (char) ((int) 'a' + i);
                if (word.charAt(pos) == change) {
                    continue;
                }
                wordBuilder.append(change);
                wordBuilder.append(word.substring(pos + 1));
                if (wordList.contains(wordBuilder.toString())) {
                    if (endWord.contentEquals(wordBuilder)) {
                        ans.add(endWord);
                        return ans;
                    }
                    for (int j = 0; j < word.length(); j++) {
                        if (j == pos) {
                            continue;
                        }
                        List<String> last = dfs(wordBuilder.toString(), endWord, wordList, new ArrayList<>(ans), j);
                        if (last.size() != 0) {
                            return last;
                        }
                    }
                }
                wordBuilder.delete(pos, word.length());
            }
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] wordList0 = {"hot","dot","dog","lot","log"};
        String beginWord = "a";
        String endWord = "c";
        String[] wordList0 = {"a", "b", "c"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordList0));
        System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
    }
}
