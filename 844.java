class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack();
        StringBuilder sb1 = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == '#' && stack.isEmpty() == false){
                stack.pop();
                
            }else if(ch != '#'){
                stack.push(ch);    
            }
            
        }
        while(stack.isEmpty() == false){
            sb1.append(stack.pop());
        }
        
        for(char ch: t.toCharArray()){
            if(ch == '#' && stack.isEmpty() == false){
                stack.pop();
                continue;
            }else if(ch !='#'){
                stack.push(ch);    
            }
            
        }
        StringBuilder sb2 = new StringBuilder();
        while(stack.isEmpty() == false){
            sb2.append(stack.pop());
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}