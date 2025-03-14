package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/14 09:03
 * https://leetcode.cn/problems/combination-sum/
 */
public class LeetCode39 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        func(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void func(int[] candidates, int target, int index, int sum, List<Integer> aPair) {
        if (sum == target) {
            ans.add(new ArrayList<>(aPair));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }
            aPair.add(candidates[i]);
            func(candidates, target, i, sum + candidates[i], aPair);
            aPair.remove(aPair.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
