package beijing.designpattern.replaceIfElse;

import java.math.BigDecimal;

/**
 * @author zhouhao
 * @date 2023/11/7 22:47
 */
public interface UserPayService {
    /**
     * 计算应付价格
     */
    BigDecimal quote(BigDecimal orderPrice);
}
