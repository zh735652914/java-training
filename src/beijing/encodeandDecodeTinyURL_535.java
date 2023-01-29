package beijing;
/*
https://leetcode.cn/problems/encode-and-decode-tinyurl/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 这题有点意思
public class encodeandDecodeTinyURL_535 {
    static public class Codec {
        private final Map<Integer, String> datbase = new HashMap<>();
        private final Random random = new Random();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int key;
            while (true) {
                key = random.nextInt();
                if (!datbase.containsKey(key)) {
                    datbase.put(key, longUrl);
                    break;
                }
            }
            return "https://tinyurl.com/" + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int index = shortUrl.indexOf("com/");
            int key = Integer.parseInt(shortUrl.substring(index + 4));
            return datbase.get(key);
        }
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec obj = new Codec();
        String tiny = obj.encode(url); // returns the encoded tiny url.
        System.out.println(tiny);
        String ans = obj.decode(tiny); // returns the original url after
        System.out.println(ans);
    }
}
