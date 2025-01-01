package next;
/**
 * https://leetcode.cn/problems/convert-date-to-binary/?envType=daily-question&envId=2025-01-01
 */

/**
 * @author zhouhao
 * @date 2025/1/1 20:52
 */
public class ConvertDateToBinary {
    static class Solution {
        public String convertDateToBinary(String date) {
            String[] nums = date.split("-");
            StringBuilder ans = new StringBuilder();
            for (String num : nums) {
                ans.append(numToBinary(Integer.parseInt(num)));
                ans.append('-');
            }
            return ans.substring(0, ans.length() - 1);
        }

        private String numToBinary(int num) {
            StringBuilder stringBuilder = new StringBuilder();
            while (num > 0) {
                stringBuilder.append(num - (num / 2) * 2);
                num >>= 1;
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(new Solution().convertDateToBinary(date));
    }
}
