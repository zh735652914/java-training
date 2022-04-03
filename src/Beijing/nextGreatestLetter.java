package Beijing;
/*
https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */

// 二分法注意一下
public class nextGreatestLetter {
    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            if (target > letters[letters.length - 1]) {
                return letters[0];
            }
            int left = 0, right = letters.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return letters[left % letters.length];
        }
    }

    static class Solution0 {
        public char nextGreatestLetter(char[] letters, char target) {
            for (char letter : letters) {
                if (letter > target) {
                    return letter;
                }
            }
            return letters[0];
        }
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'j';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }
}
