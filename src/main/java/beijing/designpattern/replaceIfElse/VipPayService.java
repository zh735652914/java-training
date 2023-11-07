package beijing.designpattern.replaceIfElse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 普通会员
 *
 * @author zhouhao
 * @date 2023/11/7 22:53
 */
@Service
public class VipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(BigDecimal.valueOf(100)) > 0) {
            return orderPrice.multiply(BigDecimal.valueOf(0.8));
        }
        return orderPrice.multiply(BigDecimal.valueOf(0.9));
    }

    @Override
    public void afterPropertiesSet() {
        UserPayServiceStrategyFactory.register("Vip", this);
    }
}
