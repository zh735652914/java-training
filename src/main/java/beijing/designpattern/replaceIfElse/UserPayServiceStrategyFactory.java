package beijing.designpattern.replaceIfElse;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouhao
 * @date 2023/11/7 22:56
 */
public class UserPayServiceStrategyFactory {
    private static final Map<String, UserPayService> services = new ConcurrentHashMap<>();

    public static UserPayService getByUserType(String type) {
        return services.get(type);
    }

    public static void register(String userType, UserPayService userPayService) {
        Assert.notNull(userType, "userType can't be null");
        services.put(userType, userPayService);
    }
}
