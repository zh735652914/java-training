package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：15358
本题知识点： 排序 数组
 算法知识视频讲解
题目描述
给出一组区间，请合并所有重叠的区间。
例如，
给出[1,3],[2,6],[8,10],[15,18],
返回[1,6],[8,10],[15,18].
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mergeIntervals {
    static public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static public class Solution {
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            ArrayList<Interval> ans = new ArrayList<>();
            Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
            int index = 0;
            while (index < intervals.size()) {
                int left = intervals.get(index).start;
                int right = intervals.get(index).end;
                while (index < intervals.size() - 1 && right >= intervals.get(index + 1).start) {
                    right = Math.max(right, intervals.get(index + 1).end);
                    index++;
                }
                ans.add(new Interval(left, right));
                index++;
            }
            return ans;
        }

        public static void main(String[] args) {
            ArrayList<Interval> intervals = new ArrayList<>();
            intervals.add(new Interval(1, 3));
            intervals.add(new Interval(2, 6));
            intervals.add(new Interval(8, 10));
            intervals.add(new Interval(15, 18));
            System.out.println(new Solution().merge(intervals));
        }
    }
}
