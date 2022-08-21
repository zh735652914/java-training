package Beijing;

// 这题的确很简单
public class isPrefixOfWord {
    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (isPrefix(searchWord, words[i])) {
                    return i + 1;
                }
            }
            return -1;
        }

        private boolean isPrefix(String searchWord, String word) {
            if (searchWord.length() > word.length()) {
                return false;
            }
            int sLen = searchWord.length(), wLen = word.length();
            for (int i = 0; i < sLen; i++) {
                if (searchWord.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(new Solution().isPrefixOfWord(sentence, searchWord));
    }
}
