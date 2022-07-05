class Solution {
    List<List<Integer>> result = new LinkedList();
    private void findPath(LinkedList<Integer> currentPath, int n, int[][] graph, int source){
        if(source == n-1){
            result.add(new LinkedList(currentPath));
        }
        for(int child: graph[source]){
            currentPath.add(child);
            this.findPath(currentPath, n, graph, child);
            currentPath.removeLast();
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        LinkedList<Integer> currentList = new LinkedList();
        currentList.add(0);
        this.findPath(currentList, n, graph, 0);
        return this.result;
    }
}