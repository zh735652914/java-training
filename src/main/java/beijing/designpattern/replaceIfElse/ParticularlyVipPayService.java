package beijing.designpattern.replaceIfElse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 专属会员
 * <p>
 * 借用 Spring 中提供的InitializingBean接口，这个接口为 Bean 提供了属性初始化后的处理方法，
 * 它只包括afterPropertiesSet方法，凡是继承该接口的类，在 Bean 的属性初始化后都会执行该方法。
 * 继承该接口可以让Spring通过IOC创建出来Bean。
 *
 * @author zhouhao
 * @date 2023/11/7 22:47
 */
@Service
public class ParticularlyVipPayService implements UserPayService, InitializingBean {
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(BigDecimal.valueOf(30)) > 0) {
            return orderPrice.multiply(BigDecimal.valueOf(0.7));
        }
        return orderPrice;
    }

    @Override
    public void afterPropertiesSet() {
        UserPayServiceStrategyFactory.register("ParticularlyVip", this);
    }
}
