package LeetCode.Contest;
/*
给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。

你可以 任意多次交换 在 pairs 中任意一对索引处的字符。

返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。



示例 1:

输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
示例 2：

输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
示例 3：

输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"


提示：

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母
 */

import java.util.ArrayList;
import java.util.List;

class SmallestStringWithSwapsSolution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] nums = s.toCharArray();
        while (pairs.size() > 0) {
            List<Integer> tmp = pairs.get(0);
            Swap(nums, tmp.get(0), tmp.get(1));
            pairs.remove(0);
        }
        String ans = String.valueOf(nums);
        return ans;
    }

    private void Swap(char[] nums, int a, int b) {
        char tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(0);
        a.add(3);
        b.add(1);
        b.add(2);
        c.add(0);
        c.add(2);
        pairs.add(a);
        pairs.add(b);
        pairs.add(c);
        SmallestStringWithSwapsSolution SSWSS = new SmallestStringWithSwapsSolution();
        System.out.println(SSWSS.smallestStringWithSwaps(s, pairs));
    }
}
