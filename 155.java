class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;
    public MinStack() {
        this.stack = new Stack();
        this.min = new Stack();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.min.size() == 0){
            this.min.push(val);
        }else{
            this.min.push(Math.min(this.min.peek(), val));
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.min.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min.peek();
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