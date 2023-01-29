package beijing;
/*
https://leetcode-cn.com/problems/stock-price-fluctuation/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

// 看了解答才写出来
public class StockPrice {
    private final Map<Integer, Integer> timePrice;
    private final TreeMap<Integer, Integer> priceTimes;
    private int current;

    public StockPrice() {
        timePrice = new HashMap<>();
        priceTimes = new TreeMap<>();
        current = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        current = Math.max(timestamp, current);
        int prePrics = timePrice.getOrDefault(timestamp, 0);
        timePrice.put(timestamp, price);
        if (prePrics > 0) {
            priceTimes.put(prePrics, priceTimes.getOrDefault(prePrics, 0) - 1);
            if (priceTimes.get(prePrics) < 1) {
                priceTimes.remove(prePrics);
            }
        }
        priceTimes.put(price, priceTimes.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timePrice.get(current);
    }

    public int maximum() {
        return priceTimes.lastKey();
    }

    public int minimum() {
        return priceTimes.firstKey();
    }

    public static void main(String[] args) {
        String[] ops = {"StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"};
        List<List<Integer>> price = new ArrayList<>();
        String str = "[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []";
        String[] S = str.split("], ");
        StockPrice obj = new StockPrice();
        for (int i = 0; i < S.length; i++) {
            List<Integer> ap = new ArrayList<>();
            if (S[i].length() < 3) {
                price.add(ap);
                continue;
            }
            String[] nums = S[i].substring(1).split(", ");
            for (String num : nums) {
                ap.add(Integer.parseInt(num));
            }
            price.add(ap);
        }
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "update":
                    System.out.println("null");
                    obj.update(price.get(i).get(0), price.get(i).get(1));
                    break;
                case "current":
                    System.out.println("current：" + obj.current());
                    break;
                case "maximum":
                    System.out.println("maximum：" + obj.maximum());
                    break;
                case "minimum":
                    System.out.println("minimum：" + obj.minimum());
                    break;
            }
        }
    }
}
