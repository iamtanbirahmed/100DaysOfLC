class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList();
        Set<Integer> indexToRemove = new HashSet();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(stack.isEmpty() == true){
                    indexToRemove.add(i);
                    continue;
                }
                stack.pop();
            }else if(ch == '('){
                stack.push(i);
            }
        }
        
        while(stack.isEmpty() == false){
            indexToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(indexToRemove.contains(i) == false){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}