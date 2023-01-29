package leetcode.programmerInterview;
/*
面试题 01.04. Palindrome Permutation LCCI
Given a string, write a function to check if it is a permutation of a palin­ drome.
A palindrome is a word or phrase that is the same forwards and backwards.
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.



Example1:

Input: "tactcoa"
Output: true（permutations: "tacocat"、"atcocta", etc.）


通过次数3,425提交次数6,515
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class canPermutePalindrome {
    static class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> hashmap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
            }
            Iterator<Character> iterator = hashmap.keySet().iterator();
            int flag = 0;
            while (iterator.hasNext()) {
                if (hashmap.get(iterator.next()) % 2 == 1) {
                    flag++;
                }
                if (flag > 1) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().canPermutePalindrome(scanner.nextLine()));
        }
    }
}
