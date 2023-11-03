package beijing;
/*
https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 */

import java.util.HashSet;
import java.util.Set;

public class uncommonFromSentences {
    static class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Set<String> uncommon = new HashSet<>();
            Set<String> common = new HashSet<>();
            String[] A = s1.split(" ");
            String[] B = s2.split(" ");
            for (int i = 0; i < A.length; i++) {
                if (!uncommon.contains(A[i]) && !common.contains(A[i])) {
                    uncommon.add(A[i]);
                } else if (!uncommon.contains(A[i])) {
                    continue;
                } else if (!common.contains(A[i])) {
                    uncommon.remove(A[i]);
                    common.add(A[i]);
                } else {
                    uncommon.remove(A[i]);
                }
            }
            for (int i = 0; i < B.length; i++) {
                if (!uncommon.contains(B[i]) && !common.contains(B[i])) {
                    uncommon.add(B[i]);
                } else if (!uncommon.contains(B[i])) {
                    continue;
                } else if (!common.contains(B[i])) {
                    uncommon.remove(B[i]);
                    common.add(B[i]);
                } else {
                    uncommon.remove(B[i]);
                }
            }
            String[] ans = new String[uncommon.size()];
            uncommon.toArray(ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour sour sour";
        String[] ans = new Solution().uncommonFromSentences(s1, s2);
        for (String s : ans) {
            System.out.print(s + ", ");
        }
    }
}
