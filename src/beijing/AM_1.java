package beijing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AM_1 {
    public static List<Character> solution(char[] input) {
        List<Character> ans = new ArrayList<>();
        if (input.length < 1) {
            return ans;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : input) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        // num[i][j]  i是字母出现的次数，j是 ch-'a'
        int[][] num = new int[count.size()][2];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            num[index++] = new int[]{entry.getValue(), entry.getKey() - 'a'};
        }
        Arrays.sort(num, Comparator.comparingInt(a -> a[0]));
        int maxCount = num[num.length - 1][0];
        index = num.length - 1;
        int ansCount = 0;
        while (--index >= 0) {
            if (num[index][0] < ansCount) {
                break;
            }
            if (num[index][0] < maxCount) {
                ansCount = num[index][0];
                ans.add((char) (num[index][1] + 'a'));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c', 'd', 'a', 'd', 'a', 'b'};
//        char[] input = {'a','b',''};
        System.out.println(solution(input));
    }
}
