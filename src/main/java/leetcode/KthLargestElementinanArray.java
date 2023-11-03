package leetcode;
/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
//自己不会写。。。

class KthLargestElementinanArraySolution {
//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(nums, 0, nums.length - 1, k);
//    }
//
//    int quickSelect(int[] nums, int low, int high, int k) {
//        int pivot = low;
//
//        // use quick sort's idea
//        // put nums that are <= pivot to the left
//        // put nums that are  > pivot to the right
//        for (int j = low; j < high; j++) {
//            if (nums[j] <= nums[high]) {
//                swap(nums, pivot++, j);
//            }
//        }
//        swap(nums, pivot, high);
//
//        // count the nums that are > pivot from high
//        int count = high - pivot + 1;
//        // pivot is the one!
//        if (count == k) return nums[pivot];
//        // pivot is too small, so it must be on the right
//        if (count > k) return quickSelect(nums, pivot + 1, high, k);
//        // pivot is too big, so it must be on the left
//        return quickSelect(nums, low, pivot - 1, k - count);
//    }
}

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        KthLargestElementinanArraySolution kthLargestElementinanArraySolution = new KthLargestElementinanArraySolution();
//        System.out.println(kthLargestElementinanArraySolution.findKthLargest(nums, k));
    }
}
