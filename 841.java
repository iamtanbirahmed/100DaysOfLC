class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        
        Stack<Integer> stack = new Stack();
        stack.push(0);
        visited.put(0, true);
        
        while(stack.isEmpty() == false){
            Integer node = stack.pop();
            for(Integer child: rooms.get(node)){
                if( visited.containsKey(child) == true && visited.get(child) == true){
                    continue;
                }
                visited.put(child, true);
                stack.push(child);
            }
            
        }
        
        return visited.keySet().size() == n;
       
        
    }
}