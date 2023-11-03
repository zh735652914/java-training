package beijing;

/**
 * @author zhouhao
 * @date 2023/9/26 12:04
 */
public class PassThePillow {
    static class Solution {
        public int passThePillow(int n, int time) {
            int count = time / (n - 1);
            int remain = time - count * (n - 1);
            if ((count & 1) == 1) {
                return n - remain;
            } else {
                return remain + 1;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(new Solution().passThePillow(n, time));
    }
}
