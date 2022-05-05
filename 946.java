class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList();
        int index = 0;
        for(int n: pushed){            
            stack.push(n);
            while(stack.isEmpty() == false && popped[index] == stack.peek()){
                stack.pop();
                index++;
            }
            
        }
        return stack.isEmpty();
    }
}