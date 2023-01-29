package leetcode;
/*
127. Word Ladder
Medium

2178

960

Add to List

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//自己没写出来，但是后来看懂了。。。
class WordLadderSolution {

    //这个版本超时了。。。
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> reached = new HashSet<>();
        Set<String> add = new HashSet<>();
        reached.add(beginWord);
        int count = 1;
        while (!reached.contains(endWord)) {
            for (String word : reached) {
                char[] CH = word.toCharArray();
                char tmp;
                for (int i = 0; i < CH.length; i++) {
                    tmp = CH[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        CH[i] = j;
                        String Nword = new String(CH);
//                        System.out.println(Nword);
                        if (wordList.contains(Nword)) {
                            wordList.remove(Nword);
                            add.add(Nword);
                        }
                    }
                    CH[i] = tmp;
                }
            }
            if (add.size() == 0) return 0;
            reached = new HashSet<>(add);
//            reached.addAll(add);
            add.clear();
            count++;
        }
        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> WordList = new HashSet<>(wordList);
        Set<String> forward = new HashSet<>();
        Set<String> backword = new HashSet<>();
        forward.add(beginWord);
        backword.add(endWord);
        return Search(forward, backword, WordList);
    }

    private int Search(Set<String> forward, Set<String> backword, Set<String> Wordlist) {
        Set<String> add = new HashSet<>();
        for (String word : forward) {
            char[] CH = word.toCharArray();
            char tmp;
            for (int i = 0; i < CH.length; i++) {
                tmp = CH[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    CH[i] = j;
                    String newword = new String(CH);
                    if (backword.contains(newword)) return 2;
                    if (!forward.contains(newword) && Wordlist.contains(newword)) {
                        Wordlist.remove(newword);
                        add.add(newword);
                    }
                }
                CH[i] = tmp;
            }
        }
        if (add.size() == 0) return 0;
        forward = add;
        int ans = forward.size() < backword.size() ? Search(forward, backword, Wordlist) : Search(backword, forward, Wordlist);
        return ans == 0 ? 0 : ans + 1;
    }
}

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
//        String[] S = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] S = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, S);
        System.out.println(new WordLadderSolution().ladderLength(beginWord, endWord, wordList));
    }
}
