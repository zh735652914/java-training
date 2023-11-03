package beijing;
/*
https://leetcode.cn/problems/making-file-names-unique/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/3/3 12:56
 */
public class GetFolderNames {
    // 自己写的，就是效率不高
    static class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> map = new HashMap<>();
            String[] ans = new String[names.length];
            for (int index = 0; index < names.length; index++) {
                if (!map.containsKey(names[index])) {
                    map.put(names[index], 1);
                    ans[index] = names[index];
                    continue;
                }
                int num = map.get(names[index]);
                while (map.containsKey(names[index] + "(" + num + ")")) {
                    num++;
                }
                String newName = names[index] + "(" + num + ")";
                map.put(names[index], num + 1);
                map.put(newName, 1);
                ans[index] = newName;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] names = {"gta", "gta(1)", "gta", "avalon"};
        String[] ans = new Solution().getFolderNames(names);
        for (String x : ans) {
            System.out.print(x + ", ");
        }
    }
}
