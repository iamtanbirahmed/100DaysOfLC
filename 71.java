class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack();
        for(String str: strs){
            if(str.length() == 0 || str.equals("."))
                continue;
            else if(str.equals("..")){
                if(stack.isEmpty() == false)
                    stack.pop();
            }else{
                stack.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(stack.isEmpty() == false){
            sb.insert(0,"/"+stack.pop());
        }
        
        return sb.length() == 0 ? "/" :sb.toString();
    }
}