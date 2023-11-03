package beijing;
/*
https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/2/8 13:14
 */
public class RemoveSubfolders {
    // 看了解析才写出来
    static class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder);
            List<String> ans = new ArrayList<>();
            ans.add(folder[0]);
            for (int i = 1; i < folder.length; i++) {
                int pre = ans.get(ans.size() - 1).length();
                if (!(pre < folder[i].length() && folder[i].substring(0, pre).equals(ans.get(ans.size() - 1)) &&
                        folder[i].charAt(pre) == '/')) {
                    ans.add(folder[i]);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(new Solution().removeSubfolders(folder));
    }
}
