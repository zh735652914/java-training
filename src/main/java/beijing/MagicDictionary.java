package beijing;
/*
https://leetcode.cn/problems/implement-magic-dictionary/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 这题作为中等题应该用字典树去写
public class MagicDictionary {
    private final Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            if (!map.containsKey(len)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(len, list);
            } else {
                map.get(len).add(s);
            }
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        List<String> list = map.get(len);
        if (list == null) {
            return false;
        }
        for (String s : list) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (searchWord.charAt(i) != s.charAt(i)) {
                    if (diff > 1) {
                        break;
                    }
                    diff++;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = new String[]{"hello", "leetcode", "judge"};
        magicDictionary.buildDict(dictionary);
        System.out.println(magicDictionary.search("hello")); // return False
        System.out.println(magicDictionary.search("hhllo")); // We can change the second 'h' to 'e' to match "hello" so we return True
        System.out.println(magicDictionary.search("hell")); // return False
        System.out.println(magicDictionary.search("leetcoded")); // return False
        System.out.println(magicDictionary.search("judge")); // return False
    }
}
