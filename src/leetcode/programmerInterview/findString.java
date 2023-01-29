package leetcode.programmerInterview;
/*
面试题 10.05. 稀疏数组搜索
稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。

示例1:

 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 输出：-1
 说明: 不存在返回-1。
示例2:

 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 输出：4
提示:

words的长度在[1, 1000000]之间
通过次数4,935提交次数8,456
 */

//完。。又是不会的一道题。。。
public class findString {
    static class Solution {
        public int findString(String[] words, String s) {
            int left = 0, right = words.length - 1;
            while (left <= right) {
                while (words[left].length() == 0) {
                    left++;
                }
                while (words[right].length() == 0) {
                    right--;
                }
                int mid = (left + right) / 2;
                while (words[mid].length() == 0) {
                    mid--;
                }
                if (words[mid].compareTo(s) == 0) {
                    return mid;
                }
                if (words[mid].compareTo(s) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String s = "ball";
        System.out.println(new Solution().findString(words, s));
    }
}
