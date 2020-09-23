package Interview;
/*

https://leetcode-cn.com/problems/number-of-2s-in-range-lcci/solution/xiao-xue-sheng-du-neng-kan-dong-de-zhao-gui-lu-fa-/
    sum=0
    依次遍历字符串（正好从高位到低位遍历一遍）：
        case(当前位大于带查找数)：
            sum +=（当前位的左边部分+1）*10**当前位的右半部分的长度
        case(当前位小于带查找数):
            sum +=（当前位的左边部分）*10**当前位的右半部分的长度
        case(当前位等于带查找数)：
            sum +=（当前位的左边部分）*10**当前位的右半部分的长度+当前位的右半部分+1

 */

import java.util.Scanner;

public class jinshan_bishi1 {
    public void solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i *= 10) {
            int tmp = n / i;

            int cur = tmp % 10;
            int tmp1 = tmp / 10;

            int tmp2 = n % i;
            ans += tmp1 * i;
            if (cur == 5) ans += tmp2 + 1;
            if (cur > 5) ans += i;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new jinshan_bishi1().solution(scanner.nextInt());
        }
    }
}
