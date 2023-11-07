package beijing.designpattern.replaceIfElse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 超级会员
 *
 * @author zhouhao
 * @date 2023/11/7 22:52
 */
@Service
public class SuperVipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        return orderPrice.multiply(BigDecimal.valueOf(0.8));
    }

    @Override
    public void afterPropertiesSet() {
        UserPayServiceStrategyFactory.register("SuperVip", this);
    }
}
