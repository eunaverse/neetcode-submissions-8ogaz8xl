class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    public MinStack() {
        stk = new Stack<Integer>();
        minStk = new Stack<Integer>();
    }
    
    public void push(int val) {
        stk.push(val);

        if(minStk.isEmpty() || minStk.peek() >= val){
            minStk.push(val);
        }
    }
    
    public void pop() {
        int top = stk.peek();
        if(top==minStk.peek()){
            minStk.pop();
        }
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
