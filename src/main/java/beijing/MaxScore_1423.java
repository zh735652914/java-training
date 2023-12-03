package beijing;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/12/3 11:27
 */
public class MaxScore_1423 {
    static class Solution {
        // 滑动窗口
        public int maxScore(int[] cardPoints, int k) {
            int remainCount = cardPoints.length - k;
            int sum = 0;
            for (int i = 0; i < remainCount; i++) {
                sum += cardPoints[i];
            }
            int minSum = sum;
            for (int i = remainCount; i < cardPoints.length; i++) {
                sum -= cardPoints[i - remainCount];
                sum += cardPoints[i];
                minSum = Math.min(minSum, sum);
            }
            return Arrays.stream(cardPoints).sum() - minSum;
        }
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(new Solution().maxScore(cardPoints, k));
    }
}
