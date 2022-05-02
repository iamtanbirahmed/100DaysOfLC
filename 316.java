class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> lastIndex = new HashMap();
        Set<Character> seen = new HashSet();
        for(int i=0;i<s.length();i++){
            lastIndex.put(s.charAt(i), i);
        }
        Deque<Character> stack = new LinkedList();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(seen.contains(ch) == false){
                while(stack.isEmpty() == false && stack.peek() > ch && lastIndex.get(stack.peek()) > i){
                    seen.remove(stack.pop());                    
                }
                stack.push(ch);
                seen.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.isEmpty() == false){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
    }
}