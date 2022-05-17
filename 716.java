class MaxStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    
    public MaxStack() {
        this.stack = new Stack();
        this.maxStack = new Stack();
    }
    
    public void push(int x) {
        this.stack.push(x);
        if(this.maxStack.isEmpty() == false){
            this.maxStack.push(Math.max(this.maxStack.peek(), x));
        }else{
            this.maxStack.push(x);
        }
    }
    
    public int pop() {
        int returnItem = this.stack.pop();
        this.maxStack.pop();
        return returnItem;
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int peekMax() {
        return this.maxStack.peek();
    }
    
    public int popMax() {
        int maxItem = this.maxStack.peek();
        Stack<Integer> temp = new Stack();
        while(this.stack.peek()!=maxItem){
            temp.push(this.pop());            
        }
        this.pop();
        while(temp.isEmpty() == false){
            this.push(temp.pop());
        }
        return maxItem;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */