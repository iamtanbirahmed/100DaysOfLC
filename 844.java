class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack();
        Stack<Character> tStack = new Stack();
        for(char ch: s.toCharArray()){
            if(sStack.isEmpty() == false && ch == '#'){
                sStack.pop();
                continue;
            }else if(ch!='#'){
                sStack.push(ch);    
            }
            
        }
        for(char ch: t.toCharArray()){
            if(tStack.isEmpty() == false && ch == '#'){
                tStack.pop();
                continue;
            }else if(ch!='#'){
                tStack.push(ch);    
            }
            
        }
        
        if(sStack.size() != tStack.size())
            return false;
        while(sStack.isEmpty() == false){
            if(sStack.peek()!=tStack.peek())
                return false;
            sStack.pop();
            tStack.pop();
        }
        return true;
    }
}