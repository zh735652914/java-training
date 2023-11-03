package beijing;

import java.util.ArrayList;
import java.util.List;

public class grayCode {
    static class Solution {
        //  关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
        public List<Integer> grayCode(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 1 << n; i++) {
                list.add(i ^ i >> 1);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().grayCode(n));
    }
}
