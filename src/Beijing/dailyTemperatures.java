package Beijing;
/*
https://leetcode.cn/problems/daily-temperatures/
 */

public class dailyTemperatures {
    // 看了评论才写出来
    static class Solution {
        // 别人的写法
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            ans[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (temperatures[i + 1] > temperatures[i]) {
                    ans[i] = 1;
                } else {
                    for (int j = i + 1; j < n; j += ans[j]) {
                        if (temperatures[j] > temperatures[i]) {
                            ans[i] = j - i;
                            break;
                        } else if (ans[j] == 0) {
                            ans[i] = 0;
                            break;
                        }
                    }
                }
            }
            return ans;
        }

        // 自己的写法不行
        public int[] dailyTemperatures0(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            ans[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                /*
                ans[i+1]==0;
                T[i]<T[i+1] ans[i]=1;
                T[i]>=T[i+1]
                    ans[i+1]==0 ?
                        ans[i]=0;
                       t=T[ans[i+1]]
                       while(t<=t[i])
                 */
                if (temperatures[i] < temperatures[i + 1]) {
                    ans[i] = 1;
                } else {
                    int right = i + 1 + ans[i + 1];
                    while (right < n && temperatures[i] >= temperatures[right]) {
                        if (ans[right] == 0) {
                            right = n;
                            break;
                        }
                        right += ans[right];
                    }
                    if (right >= n) {
                        ans[i] = 0;
                    } else {
                        ans[i] = right - i;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new Solution().dailyTemperatures(temperatures);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}