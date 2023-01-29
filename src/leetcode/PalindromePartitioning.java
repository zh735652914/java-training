package leetcode;
/*
131. Palindrome Partitioning
Medium

1296

51

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

import java.util.ArrayList;
import java.util.List;

//自己不会写。看了discuss才写出来，这个很重要！
class PalindromePartitioningSloution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, ans, list);
        return ans;
    }

    private void dfs(String s, int pos, List<List<String>> ans, List<String> list) {
        if (pos == s.length()) {
            //只能是这个，因为list为对象地址，会变
            ans.add(new ArrayList<>(list));

//            ans.add(list);
//            System.out.println("~~" + ans);
//            ans.add(new ArrayList<>(list));
//            System.out.println("##" + ans);
        } else {
            for (int i = pos + 1; i <= s.length(); i++) {
                if (isPalindrome(s.substring(pos, i))) {
                    list.add(s.substring(pos, i));
                    dfs(s, i, ans, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioningSloution().partition(s));
    }
}
