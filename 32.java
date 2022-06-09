class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty() == true){
                    stack.push(i);
                }
                max = Math.max( i -  stack.peek(), max);
            }
        }
        
        return max;
    }
}