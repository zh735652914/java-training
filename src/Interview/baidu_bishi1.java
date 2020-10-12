package Interview;

import java.util.*;

/*
4 3 4
1 2
2 3
4 3
 */
public class baidu_bishi1 {
    static class ListNode {
        int val;
        List<ListNode> next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static int count;

    static public void solution(int n, int m, int p, int[][] nums) {
        Map<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i][0])) {
                ListNode cur = map.get(nums[i][0]);
                List<ListNode> loser = cur.next;
                if (map.containsKey(nums[i][1])) {
                    loser.add(map.get(nums[i][1]));
                }
                loser.add(new ListNode(nums[i][1]));
                map.put(nums[i][0], cur);
            } else {
                ListNode winner = new ListNode(nums[i][0]);
                winner.next = new ArrayList<>();
                winner.next.add(new ListNode(nums[i][1]));
                map.put(nums[i][0], winner);
            }
        }
        ListNode cur = map.get(p);
        count = 0;
        CountLoser(cur);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n - count; i++) {
            System.out.print(i + " ");
        }
//        return ans;
    }

    static private void CountLoser(ListNode person) {
        if (person == null) {
            return;
        }
        List<ListNode> loser = person.next;
        if (loser == null) {
            return;
        }
        count += loser.size();
        for (ListNode loserPerson : loser) {
            CountLoser(loserPerson);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        solution(n, m, p, nums);
//        System.out.println(solution(n, m, p, nums));
    }
}
