package beijing;
/*
https://leetcode.cn/problems/operations-on-tree/?envType=daily-question&envId=2023-09-23
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/9/23 08:34
 */
// 这题看解析都花了很久
public class LockingTree {
    private final int[] lockNodeUser;
    private final List<Integer>[] children;
    private final int[] parent;

    public LockingTree(int[] parent) {
        this.parent = parent;
        lockNodeUser = new int[parent.length];
        Arrays.fill(lockNodeUser, -1);
        children = new List[parent.length];
        for (int i = 0; i < parent.length; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (lockNodeUser[num] == -1) {
            lockNodeUser[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockNodeUser[num] == user) {
            lockNodeUser[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (lockNodeUser[num] == -1 && !hasLockedAncestor(num) && hasLockChild(num)) {
            lockNodeUser[num] = user;
            return true;
        }
        return false;
    }

    private boolean hasLockedAncestor(int num) {
        if (num == -1) {
            return false;
        }
        if (lockNodeUser[num] != -1) {
            return true;
        }
        return hasLockedAncestor(parent[num]);
    }

    private boolean hasLockChild(int num) {
        boolean res = false;
        for (int child : children[num]) {
            if (lockNodeUser[child] != -1) {
                lockNodeUser[child] = -1;
                res = true;
            }
            res |= hasLockChild(child);
        }
        return res;
    }

    public static void main(String[] args) {
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree.lock(2, 2));   // 返回 true ，因为节点 2 未上锁。
        // 节点 2 被用户 2 上锁。
        System.out.println(lockingTree.unlock(2, 3));  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        System.out.println(lockingTree.unlock(2, 2));  // 返回 true ，因为节点 2 之前被用户 2 上锁。
        // 节点 2 现在变为未上锁状态。
        System.out.println(lockingTree.lock(4, 5));    // 返回 true ，因为节点 4 未上锁。
        // 节点 4 被用户 5 上锁。
        System.out.println(lockingTree.upgrade(0, 1)); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
        // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
        System.out.println(lockingTree.lock(0, 1));    // 返回 false ，因为节点 0 已经被上锁了。
    }
}
