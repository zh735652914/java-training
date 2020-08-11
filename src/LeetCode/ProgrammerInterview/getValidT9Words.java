package LeetCode.ProgrammerInterview;

/*
面试题 16.20. T9键盘
在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：



示例 1:

输入: num = "8733", words = ["tree", "used"]
输出: ["tree", "used"]
示例 2:

输入: num = "2", words = ["a", "b", "c", "d"]
输出: ["a", "b", "c"]
提示：

num.length <= 1000
words.length <= 500
words[i].length == num.length
num中不会出现 0, 1 这两个数字
通过次数3,588提交次数5,016
 */

import java.util.LinkedList;
import java.util.List;

//这题是第二次写了，还是不会，但是有点意思
public class getValidT9Words {
    static class Solution {
        public List<String> getValidT9Words(String num, String[] words) {
            String[] arr = {"[a-c]", "[d-f]", "[g-i]", "[j-l]", "[m-o]", "[p-s]", "[t-v]", "[w-z]"};
            StringBuilder stringBuilder = new StringBuilder(8);
            for (char number : num.toCharArray()) {
                stringBuilder.append(arr[number - '2']);
            }
            String pattern = stringBuilder.toString();
            List<String> ans = new LinkedList<>();
            for (String word : words) {
                if (word.matches(pattern)) {
                    ans.add(word);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String num = "8733";
        String[] words = {"tree", "used"};
        System.out.println(new Solution().getValidT9Words(num, words));
    }
}
