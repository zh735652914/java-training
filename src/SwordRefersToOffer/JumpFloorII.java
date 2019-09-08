package SwordRefersToOffer;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
class JumpFloorIISolution {
    public int JumpFloorII(int target) {
        if(target==1)return 1;
        if(target==2)return 2;
        return 2*JumpFloorII(target-1);
    }
}
public class JumpFloorII {
    public static void main(String[] args) {
        JumpFloorIISolution JFSII = new JumpFloorIISolution();
        int target = 4;
        System.out.println("ans=" + JFSII.JumpFloorII(target));
    }
}
