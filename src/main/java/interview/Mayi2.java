package interview;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author zhouhao
 * @date 2023/11/17 13:01
 * 题目3:尝试用java编写一个转账接口，传入主要业务参数包括转出账号，转入账号，转账金额，完成转出和转入账号的资金处理，
 * 该服务要确保在资金处理时转出账户的余额不会透支，金额计算准确
 */
public class Mayi2 {
    public boolean transfer(String sAccount, String dAccount, String amount) {
        check(sAccount, dAccount, amount);
        doTransfer(sAccount, dAccount, amount);
        return true;
    }


    private void check(String sAccount, String dAccount, String amount) {
        if (StringUtils.isEmpty(sAccount)) {
            throw new RuntimeException("转出账号为空");
        }
        if (StringUtils.isEmpty(dAccount)) {
            throw new RuntimeException("转入账号为空");
        }

        if (StringUtils.isEmpty(amount) || !isBigDecimal(amount)) {
            throw new RuntimeException("转账金额异常");
        }
    }

    private boolean isBigDecimal(String amount) {
        char[] chars = amount.toCharArray();
        if (chars.length == 1 && (chars[0] == '-' || chars[0] == '.')) {
            return false;
        }
        boolean radixPoint = false;
        int index = (chars[0] == '-') ? 1 : 0;
        while (index < chars.length) {
            if (chars[index] == '.') {
                if (radixPoint) return false;
                radixPoint = true;
            } else if (!(chars[index] >= '0' && chars[index] <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从其他服务或者数据库获取预额
     *
     * @param account
     * @return
     */
    private BigDecimal getRemainAmount(String account) {
        return new BigDecimal("1000000");
    }

    /**
     * 日志记录
     *
     * @param account
     * @param amount
     */
    private void updateLog(String account, String amount) {

    }

    /**
     * @param account
     * @param amount
     */
    private void updateAccount(String account, BigDecimal amount) {

    }

    private BigDecimal toBigDecimal(String amount) {
        return new BigDecimal("11");
    }


    //    @Transactional(rollbackFor = Exception.class)
    public void doTransfer(String sAccount, String dAccount, String amount) {

        // 用户的余额，这一步要根据系统要求，看看从哪里获取
        BigDecimal sRemain = getRemainAmount(sAccount);
        BigDecimal dRemain = getRemainAmount(dAccount);

        if (sRemain.compareTo(toBigDecimal(amount)) < 0) {
            throw new RuntimeException("余额不足！");
        }

        updateLog(sAccount, amount);
        updateLog(dAccount, amount);

    }
}
