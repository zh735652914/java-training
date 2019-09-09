package SwordRefersToOffer;

import java.util.Stack;

/*
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */
class myStackSolution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> st=new Stack();
        int pos=0;
        for (int i = 0; i < pushA.length; i++) {
            st.push(pushA[i]);
            while (!st.empty()&&st.peek()==popA[pos]&&pos<popA.length){
                pos++;
                st.pop();
            }
        }
        return st.empty();
    }
}

public class myStack {
    public static void main(String[] args) {
        myStackSolution MSS = new myStackSolution();
        int[] psuhA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popB = {4, 3, 5, 1, 2};
        if (MSS.IsPopOrder(psuhA, popB)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
