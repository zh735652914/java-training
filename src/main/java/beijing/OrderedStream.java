package beijing;
/*
https://leetcode.cn/problems/design-an-ordered-stream/
 */

import java.util.ArrayList;
import java.util.List;

// 题目看懂就行
public class OrderedStream {
    private int ptr;
    private final String[] strs;

    public OrderedStream(int n) {
        ptr = 1;
        strs = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        strs[idKey] = value;
        List<String> ans = new ArrayList<>();
        if (strs[ptr] != null) {
            while (ptr < strs.length && strs[ptr] != null) {
                ans.add(strs[ptr]);
                strs[ptr++] = null;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
        System.out.println(os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        System.out.println(os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        System.out.println(os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
        System.out.println(os.insert(4, "ddddd")); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
        // Concatentating all the chunks returned:
        // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
        // The resulting order is the same as the order above.
    }
}
