package swordreferstooffer;
/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

class JumpFloorSolution {
    public int JumpFloor(int target) {
        if(target==1)return 1;
        if(target==2)return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}

public class JumpFloor {
    public static void main(String[] args) {
        JumpFloorSolution JFS = new JumpFloorSolution();
        int target = 10;
        System.out.println("ans=" + JFS.JumpFloor(target));
    }
}
