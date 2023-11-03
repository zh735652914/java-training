package leetcode;

import java.util.ArrayList;
import java.util.List;

class GrayCodeSolution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<Integer> Lastans = grayCode(n - 1);
        int len = (int) Math.pow(2, n - 1);
        int num = Lastans.size();
        for (int i = 1; i <= len; i++) {
            Lastans.add(Lastans.get(num - i) + len);
        }
        return Lastans;
    }
//
//    private List<Integer> bracktrack(int n) {
//        if (n == 0) {
//            List<Integer> ans = new ArrayList<>();
//            ans.add(0);
//            return ans;
//        }
//        List<Integer> Lastans = bracktrack(n - 1);
//        int len = (int) Math.pow(2, n - 1);
//        int num = Lastans.size();
//        for (int i = 1; i <= len; i++) {
//            Lastans.add(Lastans.get(num - i) + len);
//        }
//        return Lastans;
//    }
}

public class GrayCode {
    public static void main(String[] args) {
        int n = 4;
        GrayCodeSolution GC = new GrayCodeSolution();
        List<Integer> ans = GC.grayCode(n);
        System.out.println(ans);
    }
}
