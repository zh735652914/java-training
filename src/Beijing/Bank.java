package Beijing;
/*
https://leetcode-cn.com/problems/simple-bank-system/
 */

// 这题没有意义
public class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > balance.length || account2 > balance.length || money > balance[account1 - 1]) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || money > balance[account - 1]) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

    public static void main(String[] args) {
        String[] ops = {"Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"};
        long[][] nums = {{10, 100, 20, 50, 30}, {3, 10}, {5, 1, 20}, {5, 20}, {3, 4, 15}, {10, 50}};
        Bank bank = new Bank(nums[0]);
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "deposit":
                    System.out.println(bank.deposit((int) nums[i][0], nums[i][1]));
                    break;
                case "withdraw":
                    System.out.println(bank.withdraw((int) nums[i][0], nums[i][1]));
                    break;
                case "transfer":
                    System.out.println(bank.transfer((int) nums[i][0], (int) nums[i][1], nums[i][2]));
                    break;
            }
        }
    }
}
