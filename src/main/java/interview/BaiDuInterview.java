package interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author zhouhao
 * @date 2023/9/19 16:09
 */
public class BaiDuInterview {
    public static List<String> topKFrequent(String file, int N, long batchSize) {
        PriorityQueue<SearchWord> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        HashMap<String, Integer> freqMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                freqMap.put(line, freqMap.getOrDefault(line, 0) + 1);
                if (freqMap.size() >= batchSize) {
                    // 处理数据
                    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                        priorityQueue.offer(new SearchWord(entry.getKey(), entry.getValue()));
                        if (priorityQueue.size() > N) {
                            priorityQueue.poll();
                        }
                    }
                    freqMap.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 加载最后一个批次
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            priorityQueue.offer(new SearchWord(entry.getKey(), entry.getValue()));
        }
        while (priorityQueue.size() > N) {
            priorityQueue.poll();
        }
        // 构建结果列表
        List<String> topK = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            topK.add(priorityQueue.poll().word);
        }
        Collections.reverse(topK);
        return topK;
    }

    private static class SearchWord {
        String word;
        int freq;

        public SearchWord(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/zhouhao/test0919.txt";
        long maxLine = 0;
        try {
            maxLine = Files.lines(Paths.get(path)).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int N = 5;
        long batchSize = maxLine / N < N ? maxLine / N : N; // 防止每批次数据大于N
        List<String> ans = topKFrequent(path, N, batchSize);
        System.out.println(ans);
    }
}
