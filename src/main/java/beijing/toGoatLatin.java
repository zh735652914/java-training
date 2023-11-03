package beijing;
/*
https://leetcode-cn.com/problems/goat-latin/
 */

public class toGoatLatin {
    // 细心一点就行
    static class Solution {
        public String toGoatLatin(String sentence) {
            String[] words = sentence.split(" ");
            StringBuilder ans = new StringBuilder();
            StringBuilder wd = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (isVowel(words[i].charAt(0))) {
                    wd.append(words[i]);
                } else {
                    wd.append(words[i].substring(1));
                    wd.append(words[i].charAt(0));
                }
                wd.append("ma");
                for (int j = 0; j <= i; j++) {
                    wd.append('a');
                }
                ans.append(wd);
                ans.append(' ');
                wd.delete(0, wd.length());
            }
            ans.deleteCharAt(ans.length() - 1);
            return ans.toString();
        }

        private boolean isVowel(char x) {
            x = Character.toLowerCase(x);
            return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
        }
    }

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        System.out.println(new Solution().toGoatLatin(sentence));
    }
}
