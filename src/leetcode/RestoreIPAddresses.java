package leetcode;
/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

class RestoreIPAddressesSolution {
    public List<String> restoreIpAddresses(String s) {
        int[] nums = new int[4];
        List<String> ans = new ArrayList<>();
        return backtrack(s, nums, 0, 0, ans);
    }

    private List<String> backtrack(String s, int[] nums, int n, int pos, List<String> ans) {
        if (n == 4 && pos == s.length()) {
            String aAns = nums[0] + "." + nums[1] + "." + nums[2] + "." + nums[3];
            ans.add(aAns);
            return ans;
        }
        if (n == 4 || pos == s.length()) return ans;
        for (int i = 1; i <= 3 && (pos + i) <= s.length(); i++) {
            String tmp = s.substring(pos, pos + i);
            int sum = Integer.valueOf(tmp);
            if (sum < 256 && sum > 0 && !(i >= 2 && s.charAt(pos) == '0')) {
                nums[n] = sum;
                ans = backtrack(s, nums, n + 1, pos + i, ans);
            }
        }
        return ans;
    }
}

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddressesSolution RIPA = new RestoreIPAddressesSolution();
        String s = "25525511135";
        System.out.println(RIPA.restoreIpAddresses(s));
    }
}
