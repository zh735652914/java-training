package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/15 09:12
 * https://leetcode.cn/problems/permutations/
 */
public class LeetCode46 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        func(nums, new ArrayList<>());
        return ans;
    }

    private void func(int[] nums, List<Integer> aPair) {
        if (aPair.size() == nums.length) {
            ans.add(new ArrayList<>(aPair));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            aPair.add(nums[i]);
            visited[i] = true;
            func(nums, aPair);
            aPair.remove(aPair.size() - 1);
            visited[i] = false;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
