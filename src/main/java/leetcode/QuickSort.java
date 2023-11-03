package leetcode;

//看了算法导论上的快排，然后自己手写的
public class QuickSort {
    static class MAIN {
        public static void main(String[] args) {
            int[] nums = {1, 3, 2, 4, 7, 8, 5, 4, 6, 9, 11};
//            int[] nums = {2, 8, 7, 1, 3, 5, 6, 4};
            int[] ans = new QuickSort().quickSort(nums);
            for (int x : ans) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    public int[] quickSort(int[] nums) {
        Sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void Sort(int[] nums, int start, int end) {
        if (start < end) {
            int pos = partition(nums, start, end);
            Sort(nums, 0, pos - 1);
            Sort(nums, pos + 1, end);
        }
    }

    // 代码参考 Sedgewick 的《算法4》
    public int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private int partition0(int[] nums, int start, int end) {
        int x = nums[end];
        int last = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= x) {
                last++;
                swap(nums, last, i);
            }
        }
        swap(nums, last + 1, end);
        return last + 1;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
