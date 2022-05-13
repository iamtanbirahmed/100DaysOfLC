class MyStack {
    
    private Queue<Integer> q1;
    private int top;
    
    
    public MyStack() {        
        this.q1 = new LinkedList();
    }
    
    public void push(int x) {
        this.q1.offer(x);
        int size = this.q1.size();
        while(size > 1){
            this.q1.offer(this.q1.poll());
            size--;
        }        
    }
    
    public int pop() {
        return this.q1.poll();
    }
    
    public int top() {
       return this.q1.peek();
    }
    
    public boolean empty() {
        return this.q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */