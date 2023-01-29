package beijing;
/*
https://leetcode-cn.com/problems/evaluate-division/
 */

import java.util.ArrayList;
import java.util.List;

public class evaluateDivision {
    /*
    思路是建图，然后搜索
     */
    static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] ans = new double[queries.size()];
            // TODO: 2022/5/3 方法体待完成
            return new double[]{};
        }
    }

    public static void main(String[] args) {
        /*
        a=2;
        b=1;
        c=1/3;
        equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
         */
//        String[][] E = {{"a", "b"}, {"b", "c"}};
//        String[][] Q = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
//        double[] values = {2.0, 3.0};

        /*
        [["a","b"],["e","f"],["b","e"]]
[3.4,1.4,2.3]
[["b","a"],["a","f"],["f","f"],["e","e"],["c","c"],["a","c"],["f","e"]]

        a=3.4
        b=1
        e=1.4
        f=1

         */
        String[][] E = {{"a", "b"}, {"e", "f"}, {"b", "e"}};
        double[] values = {3.4, 1.4, 2.3};
        String[][] Q = {{"b", "a"}, {"a", "f"}, {"f", "f"}, {"e", "e"}, {"c", "c"}, {"a", "c"}, {"f", "e"}};
        List<List<String>> equations = new ArrayList<>();
        for (String[] e : E) {
            List<String> aE = new ArrayList<>();
            aE.add(e[0]);
            aE.add(e[1]);
            equations.add(aE);
        }
        List<List<String>> queries = new ArrayList<>();
        for (String[] q : Q) {
            List<String> aQ = new ArrayList<>();
            aQ.add(q[0]);
            aQ.add(q[1]);
            queries.add(aQ);
        }
        double[] ans = new Solution().calcEquation(equations, values, queries);
        for (double x : ans) {
            System.out.print(x + ", ");
        }
    }
}
