class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
            
        for(char ch: chars){
            switch(ch){
                case ')':
                    if(stack.size() == 0 ||stack.peek() != '('){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                    
                case '}':
                    if(stack.size() == 0 ||stack.peek() != '{'){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                case ']':
                    if(stack.size() == 0 ||stack.peek() != '['){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(ch);
                    
                    
            }
        }
        return stack.size() == 0;
        
    }
}