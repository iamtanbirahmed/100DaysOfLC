class Solution {
    
    LinkedList<List<Integer>> result = new LinkedList<>();
    
    public void findPath(LinkedList<Integer> currentPath, int root, int target, int[][] graph){
        if(graph.length == root) return;
        
        currentPath.add(root);
        if(root == target){
            LinkedList<Integer> tmp = new LinkedList(currentPath);
            this.result.add(tmp);
        }
        
        for(int child: graph[root]){
            findPath(currentPath, child, target, graph);
        }
        currentPath.removeLast();
    }
    
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.findPath(new LinkedList<Integer>(), 0, graph.length-1, graph);
        
        return result;
    }
}