package swordreferstooffer;

/*
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
class RectCoverSolution {

    //以下代码自己写的，在牛客网上无法通过，很奇怪
//    public int RectCover(int target) {
//        if (target == 1) return 1;
//        if (target == 2) return 2;
//        return RectCover(target - 1) + RectCover(target - 2);
//    }

    //下面是牛客网上可以通过的代码，有区别吗？？？
    public int RectCover(int target) {
        if(target <=2){
            return target;
        }else{
            return RectCover(target-1) + RectCover(target-2);
        }
    }
}

public class RectCover {
    public static void main(String[] args) {
        int target = 5;
        RectCoverSolution RCS = new RectCoverSolution();
        System.out.println("ans=" + RCS.RectCover(target));
    }
}
