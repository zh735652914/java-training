package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/20 08:29
 * https://leetcode.cn/problems/subsets/
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> nextSub = new ArrayList<>();
            for (List<Integer> aSub : ans) {
                List<Integer> subNew = new ArrayList<>(aSub);
                subNew.add(num);
                nextSub.add(subNew);
            }
            ans.addAll(nextSub);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
