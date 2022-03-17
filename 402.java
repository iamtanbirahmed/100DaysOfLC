class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        int end = 0;
        while(end < num.length()){
            char ch = num.charAt(end);
            while(stack.isEmpty() == false && stack.peek() > ch && k>0){
                stack.pop();
                k--;
            }
            stack.push(ch);
            end++;
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.isEmpty() == false){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0) return "0";
        
        return sb.toString();
    }
}