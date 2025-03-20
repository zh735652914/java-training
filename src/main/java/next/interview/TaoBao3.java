package next.interview;

import org.junit.Test;

import java.util.Random;

/**
 * @author zhouhao
 * @date 2025/3/20 22:28
 */
public class TaoBao3 {
    public double[] func(double allMoney, int peopleNum) {
        if (peopleNum <= 0 || allMoney < peopleNum) {
            // 异常情况
            return new double[]{};
        }

        double minMoney = 1; // 最少每个人的钱
        double maxAmount = Math.min(30 * allMoney / 100, allMoney - peopleNum + 1); //最多的钱

        Random random = new Random();
        double[] amounts = new double[peopleNum];
        double availMoney = allMoney - peopleNum; // 可以分配的钱

        for (int i = 0; i < peopleNum - 1; i++) {
            // 计算当前人可以拿到的最大金额
            double maxCurrent = Math.min(maxAmount - minMoney, availMoney - (peopleNum - i - 1) * minMoney);
            double currentAmount = random.nextDouble() * maxCurrent + minMoney;
            amounts[i] = currentAmount;
            availMoney -= currentAmount;
        }
        amounts[peopleNum - 1] = availMoney + minMoney;

        return amounts;
    }

    @Test
    public void test() {
        double totalAmount = 100; // 总金额
        int people = 10;  // 分红包的人数

        double[] redPackets = func(totalAmount, people);

//        double sum = 0;
        for (double amount : redPackets) {
//            System.out.println(amount);
            System.out.printf("%.2f ", amount);
//            sum += amount;
        }
//        System.out.println("sum = " + sum);
    }
}
