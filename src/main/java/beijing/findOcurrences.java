package beijing;

/*
https://leetcode-cn.com/problems/occurrences-after-bigram/
 */
public class findOcurrences {
    static class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] T = text.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            int p = 0, q = 1;
            while (q < T.length) {
                if (T[p].equals(first) && T[q].equals(second) && q + 1 < T.length) {
                    stringBuilder.append(T[q + 1]);
                    stringBuilder.append(",");
                }
                p++;
                q++;
            }
            return stringBuilder.length() == 0 ? new String[0] : stringBuilder.toString().split(",");
        }
    }

    public static void main(String[] args) {
//        String text = "alice is a good girl she is a good student", first = "a", second = "good";
        String text = "obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre",
                first = "jnvavldde",
                second = "y";
        String[] ans = new Solution().findOcurrences(text, first, second);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
    }
}
