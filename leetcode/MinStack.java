import java.util.Stack;

public class MinStack {

    // stack 을 구현 하는데, 이 스택은 push, pop, top, getMin 을 구현해야 한다.
    // 스택에 저장되는 각 데이터가 자기까지의 데이터 중 최솟값을 저장하도록 구현함
    int min;
    Stack<Data> stack;
    class Data {
        int val;
        int min;
        public Data(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }

    public void push(int x) {
        min = min > x ? x : min;
        stack.push(new Data(x, min));
    }

    public void pop() {
        stack.pop();
        if (stack.isEmpty()) min = Integer.MAX_VALUE;
        else min = stack.peek().min;
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;

    }
}
