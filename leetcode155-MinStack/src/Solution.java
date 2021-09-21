import java.util.Stack;

class MinStack {

    int min;
    int lastmin;
    Stack<Integer> minstack;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
        }else{
            min = Math.min(min,val);
        }
        minstack.push(min);
        stack.push(val);
    }

    public void pop() {
        minstack.pop();
        if(!minstack.isEmpty()) {
            min = minstack.peek();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */