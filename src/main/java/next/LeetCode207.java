package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * @author zhouhao
 * @date 2025/4/3 08:21
 * https://leetcode.cn/problems/course-schedule/
 */
public class LeetCode207 {
    List<List<Integer>> edge = new ArrayList<>();
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edge.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1;// 访问中
        for (int v : edge.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        assertFalse(canFinish(numCourses, prerequisites));
    }
}
