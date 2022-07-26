class Solution {
    private List<List<Integer>> result = new LinkedList();
    private void findPaths(LinkedList<Integer> currentPath, int source, int[][] graph, int target){
        if(source == target){
            this.result.add(new LinkedList(currentPath));
        }
        for(int n: graph[source]){
            currentPath.add(n);
            this.findPaths(currentPath, n, graph, target);
            currentPath.removeLast();
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length-1;
        LinkedList<Integer> currentPath = new LinkedList();
        currentPath.add(0);
        this.findPaths(currentPath, 0, graph, target);
        return this.result;
    }
}