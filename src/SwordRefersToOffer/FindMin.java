package SwordRefersToOffer;
/*
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Scanner;
import java.util.Stack;

class FindMinSolution {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minst = new Stack<>();

    public void push(int node) {
        if (minst.empty()) {
            minst.push(node);
        } else if (minst.peek() <= node) {
            minst.push(minst.peek());
        } else {
            minst.push(node);
        }
        st.push(node);
    }

    public void pop() {
        st.pop();
        minst.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return minst.peek();
    }
}

public class FindMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FindMinSolution FMS = new FindMinSolution();
        while (true) {
            int node = sc.nextInt();
            FMS.push(node);
            System.out.println("min=" + FMS.min());
        }
    }
}
