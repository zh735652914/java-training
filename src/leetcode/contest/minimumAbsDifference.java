package leetcode.contest;
/*
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。



示例 1：

输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：

输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：

输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]

提示：

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class minimumAbsDifferenceSolution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
//        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> ans = new ArrayList<>();
        if (arr.length < 2) return ans;
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int tmp = Math.abs(arr[i] - arr[i - 1]);
            if (tmp < diff) diff = tmp;
        }
        for (int i = 1; i < arr.length; i++) {
            int tmp = Math.abs(arr[i] - arr[i - 1]);
            if (tmp == diff) {
                List<Integer> aAns = new ArrayList<>();
                aAns.add(arr[i - 1]);
                aAns.add(arr[i]);
                ans.add(aAns);
            }
        }
        return ans;
    }
}

public class minimumAbsDifference {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        minimumAbsDifferenceSolution MADS = new minimumAbsDifferenceSolution();
        System.out.println(MADS.minimumAbsDifference(arr));
    }
}
