package Beijing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/shortest-completing-word/
 */
public class shortestCompletingWord {
    static class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            Map<Integer, Integer> map = new HashMap<>(words.length);
            licensePlate = licensePlate.toLowerCase();
            for (int i = 0; i < licensePlate.length(); i++) {
                char key = licensePlate.charAt(i);
                if (key >= 'a' && key <= 'z') {
                    map.put(licensePlate.charAt(i) - 'a',
                            map.getOrDefault(licensePlate.charAt(i) - 'a', 0) + 1);
                }
            }
            Map<Integer, Integer> count = new HashMap<>(map);
            int Length = Integer.MAX_VALUE, ans = -1;
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
                for (int j = 0; j < words[i].length(); j++) {
                    int key = words[i].charAt(j) - 'a';
                    if (count.containsKey(key)) {
                        count.put(key, count.get(key) - 1);
                        if (count.get(key) == 0) {
                            count.remove(key);
                        }
                    }
                }
                if (count.isEmpty() && words[i].length() < Length) {
                    ans = i;
                    Length = words[i].length();
                }
                count = new HashMap<>(map);
            }
            return words[ans];
        }

        public String shortestCompletingWord2(String licensePlate, String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int[] arr = new int[26];
            int sum = 0;
            for (char ch : licensePlate.toLowerCase().toCharArray()) {
                if (Character.isLowerCase(ch)) {
                    arr[ch - 'a']++;
                    sum++;
                }
            }
            for (String word : words) {
                int[] tmp_arr = Arrays.copyOf(arr, arr.length);
                int tmp_sum = 0;
                char[] chs = word.toCharArray();
                for (char ch : chs) {
                    if (tmp_arr[ch - 'a'] > 0) {
                        tmp_arr[ch - 'a']--;
                        tmp_sum++;
                    }
                    if (sum == tmp_sum) {
                        return word;
                    }
                }
            }
            return "NOT FOUND!";
        }
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(new Solution().shortestCompletingWord2(licensePlate, words));
    }
}
