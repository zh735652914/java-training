package beijing;
/*
https://leetcode-cn.com/problems/lexicographical-numbers/
 */

import java.util.LinkedList;
import java.util.List;

// 自己没写出来
public class LexicographicalNumbers {
    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ans = new LinkedList<>();
            int num = 1;
            for (int i = 0; i < n; i++) {
                ans.add(num);
                if (num * 10 <= n) {
                    num *= 10;
                } else {
                    while (num % 10 == 9 || num + 1 > n) {
                        num /= 10;
                    }
                    num++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 131;
        System.out.println(new Solution().lexicalOrder(n));
    }
}
