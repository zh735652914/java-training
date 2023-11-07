package beijing.designpattern.replaceIfElse;

import java.math.BigDecimal;

/**
 * @author zhouhao
 * @date 2023/11/7 23:00
 * <p>
 * <p>
 * 还不能直接执行，需要Spring框架去注册Bean，注册Bean的时候会把相关对象放到map中
 */
public class MainTest {
    public static void main(String[] args) {
        User user = new User("SuperVip");
        System.out.println(calPrice(BigDecimal.valueOf(100), user));
    }

    public static BigDecimal calPrice(BigDecimal orderPrice, User user) {
        UserPayService strategy = UserPayServiceStrategyFactory.getByUserType(user.getVipType());
        return strategy.quote(orderPrice);
    }
}
