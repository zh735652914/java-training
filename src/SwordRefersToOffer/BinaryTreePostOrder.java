package SwordRefersToOffer;

import java.util.Arrays;

/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。
 */
/*
sequence=[]的时候，居然要求放回false；
 */
class BinaryTreePostOrderSolution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return backtrack(sequence);
    }

    public boolean backtrack(int[] sequence) {
        if (sequence.length < 3) return true;
        int root = sequence[sequence.length - 1];
        int pos = 0, flag = 1;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (flag == 0 && sequence[i] < root) return false;
            if (sequence[i] > root && flag == 1) {
                pos = i;
                flag = 0;
            }
        }
        return backtrack(Arrays.copyOfRange(sequence, 0, pos)) && backtrack(Arrays.copyOfRange(sequence, pos, sequence.length - 1));
    }
}

public class BinaryTreePostOrder {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
//        int[] sequence = {6, 9, 7, 15, 17, 13, 5};//YES
//        int[] sequence = {13, 5, 8, 15, 14, 7};//NO
//        int[] sequence = {};
        BinaryTreePostOrderSolution BTPO = new BinaryTreePostOrderSolution();
        if (BTPO.VerifySquenceOfBST(sequence)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
//        BTPO.VerifySquenceOfBST(sequence)?System.out.println("YES"):System.out.println("NO");
    }
}
