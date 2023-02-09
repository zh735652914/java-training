package beijing;
/*
https://leetcode.cn/problems/design-authentication-manager/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/9 12:43
 */
// 其实很简单的题目
public class AuthenticationManager {
    private final int timeToLive;
    private final Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) + timeToLive > currentTime) {
                map.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        System.out.println(authenticationManager.countUnexpiredTokens(6)); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        System.out.println(authenticationManager.countUnexpiredTokens(15)); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
    }
}
