package next.interview;

import java.util.Random;

/**
 * @author zhouhao
 * @date 2025/3/20 22:17
 */
/*
//3. 红包算法，给定一个红包总金额和分红包的人数，输出每个人随机抢到的红包金额（选做题）

//要求：

//1. 每个人都要抢到红包，并且金额随机

//2. 每个人抢到的金额数不小于1

//3. 每个人抢到的金额数不超过总金额的30%

//例如总金额100，人数10，输出【19 20 15 1 25 14 2 2 1 1】
 */
public class RedPacketDistributor {
    public static void main(String[] args) {
        double totalAmount = 100; // 总金额
        int numberOfPeople = 10;  // 分红包的人数

        // 调用分红包方法并获取每个人抢到的金额
        double[] redPackets = distributeRedPackets(totalAmount, numberOfPeople);

        double sum = 0;

        // 打印每个人抢到的红包金额
        for (double amount : redPackets) {
//            System.out.println(amount);
            System.out.printf("%.2f ", amount); // 使用%.0f格式化输出整数金额
            sum += amount;
        }
        System.out.println("sum = " + sum);
    }

    /**
     * 分配红包的方法
     *
     * @param totalAmount    总金额
     * @param numberOfPeople 分红包的人数
     * @return 包含每个人抢到的金额的数组
     */
    public static double[] distributeRedPackets(double totalAmount, int numberOfPeople) {
        if (numberOfPeople <= 0 || totalAmount < numberOfPeople) {
            throw new IllegalArgumentException("输入错误"); // 输入无效时抛出异常
        }

        double minAmount = 1; // 每个人至少能拿到1元
        // 每个人最多能拿到总金额的30%，但不能超过剩余金额减去最少金额后的值
        double maxAmount = Math.min(30 * totalAmount / 100, totalAmount - numberOfPeople + 1);

        Random random = new Random(); // 创建随机数生成器
        double[] amounts = new double[numberOfPeople]; // 存储每个人抢到的金额
        double remainingAmount = totalAmount - numberOfPeople; // 减去每个人的最低金额1元后剩下的金额

        // 分配前n-1个人的红包
        for (int i = 0; i < numberOfPeople - 1; i++) {
            // 计算当前人可以拿到的最大金额
            double maxCurrent = Math.min(maxAmount - minAmount, remainingAmount - (numberOfPeople - i - 1) * minAmount);
            // 生成一个在允许范围内的随机金额
            double currentAmount = random.nextDouble() * maxCurrent + minAmount;
            amounts[i] = currentAmount; // 将生成的金额存入数组
            remainingAmount -= currentAmount; // 更新剩余金额
        }

        // 最后一个人拿走剩下的所有金额加上最低金额（1元）
        amounts[numberOfPeople - 1] = remainingAmount + minAmount;

        return amounts; // 返回包含每个人抢到的金额的数组
    }
}
