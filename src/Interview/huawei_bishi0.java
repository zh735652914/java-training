package Interview;
/*
performance
Adam,125
Andy,110
Bill,92
Evan,154
organization
Aaron,Abel,Adam
Aaron,Abel,Andy
Aaron,Jone,Bill
Aaron,Jone,Evan
eof
 */

import java.util.*;

public class huawei_bishi0 {
    Map<String, Integer> map_count0;
    Map<String, List<String>> map;
    Map<String, List<String>> map_next;
    Map<String, Integer> map_count1;
    Map<String, Integer> map_count2;

//    public void solution1(List<String[]> performance, List<String[]> organization) {
//        Map<String, people> name_map = new HashMap<>();
//        for (String[] name : performance) {
//            people cur = new people(name[0], new ArrayList<>(), Integer.parseInt(name[1]));
//            name_map.put(name[0], cur);
//        }
//        for (String[] chain : organization) {
//            chain
//        }
//    }

    public void solution(List<String[]> performance, List<String[]> organization) {
        map_count0 = new HashMap<>(performance.size());
        for (String[] strings : performance) {
            map_count0.put(strings[0], Integer.parseInt(strings[1]));
        }
        map = new HashMap<>();
        map_next = new HashMap<>();
        for (String[] cur : organization) {
            List<String> next;
            if (map.containsKey(cur[0])) {
                next = map.get(cur[0]);
            } else {
                next = new ArrayList<>();
            }
            if (!next.contains(cur[1])) {
                next.add(cur[1]);
            }
            map.put(cur[0], next);
            if (map_next.containsKey(cur[1])) {
                next = map_next.get(cur[1]);
            } else {
                next = new ArrayList<>();
            }
            if (!next.contains(cur[2])) {
                next.add(cur[2]);
            }
            map_next.put(cur[1], next);
        }
        map_count1 = new HashMap<>();
        for (String mid : map_next.keySet()) {
            List<String> next_people = map_next.get(mid);
            int count = 0;
            for (String people : next_people) {
                count += map_count0.get(people);
            }
            map_count1.put(mid, count);
        }
        map_count2 = new HashMap<>();
        for (String top : map.keySet()) {
            List<String> next_people = map.get(top);
            int count = 0;
            for (String people : next_people) {
                count += map_count1.get(people);
            }
            map_count2.put(top, count);
        }


//        for (String top : map.keySet()) {
//            System.out.println(top + "<" + map_count2.get(top) + ">");
//            List<String> mids = map.get(top);
//            for (String mid : mids) {
//                System.out.println("-" + mid + "<" + map_count1.get(mid) + ">");
//                List<String> downs = map_next.get(mid);
//                for (String down : downs) {
//                    System.out.println("--" + down + "<" + map_count0.get(down) + ">");
//                }
//            }
//        }


        List<people> tops = new ArrayList<>();
        for (String top : map.keySet()) {
            people top_p = new people(top, map.get(top), map_count2.get(top));
            tops.add(top_p);
        }
        sort(tops);
//        List<people> mids = new ArrayList<>();
//        for (String mid : map_next.keySet()) {
//            people mid_p = new people(mid, map_next.get(mid), map_count1.get(mid));
//            mids.add(mid_p);
//        }
//        sort(mids);
        List<people> downs = new ArrayList<>();
        for (String down : map_count0.keySet()) {
            people down_p = new people(down, new ArrayList<>(), map_count0.get(down));
            downs.add(down_p);
        }
        sort(downs);

        for (people top : tops) {
            System.out.println(top.name + "-" + "<" + top.work + ">");
            List<String> next = top.next;
//            out_mid(next);
        }
    }

    public void out_mid(List<people> list) {
        List<people> mids = new ArrayList<>();
        for (String mid : map_next.keySet()) {
            people mid_p = new people(mid, map_next.get(mid), map_count1.get(mid));
            mids.add(mid_p);
        }
        sort(mids);
        for (people mid : mids) {
            System.out.println("-" + mid.name + "<" + mid.work + ">");
        }

    }

    public void sort(List<people> list) {
        Collections.sort(list, new Comparator<people>() {
            @Override
            public int compare(people o1, people o2) {
                return o1.work - o2.work;
            }
        });
    }

    static class people {
        String name;
        List<String> next;
        int work;
        List<people> next_people = null;

        people(String name, List<String> next, int work) {
            this.name = name;
            this.next = next;
            this.work = work;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> performance = new ArrayList<>();
        List<String[]> organization = new ArrayList<>();
        String s = scanner.nextLine();
        if (s.equals("performance")) {
            while (scanner.hasNext()) {
                String cur = scanner.next();
                if (cur.equals("organization")) {
                    break;
                } else {
                    performance.add(cur.split(","));
                }
            }
        }
        while (scanner.hasNext()) {
            String cur = scanner.next();
            if (cur.equals("eof")) {
                break;
            } else {
                organization.add(cur.split(","));
            }
        }
        new huawei_bishi0().solution(performance, organization);
    }
}
