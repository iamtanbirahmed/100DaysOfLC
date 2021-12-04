class Solution {
    
    public boolean[] dfs(int n, LinkedList<Integer>[] graph, boolean[] visited){
        if(visited[n] == true) return visited;
        visited[n] = true;
        
        // if the node does not have any neighbours
        if(graph[n] == null) return visited; 
        
        for(Integer child: graph[n] ){
            visited = this.dfs(child, graph, visited);
        }
        return visited;
        
    } 
    
    public int countComponents(int n, int[][] edges) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<edges.length;i++){
            if(graph[edges[i][0]] == null){
                graph[edges[i][0]] = new LinkedList();
            }
            graph[edges[i][0]].add(edges[i][1]);
            
            if(graph[edges[i][1]] == null){
                graph[edges[i][1]] = new LinkedList();
            } 
            
            graph[edges[i][1]].add(edges[i][0]); 
        }
        int connectedComponents = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                connectedComponents++;
                visited = this.dfs(i, graph, visited);
            }            
        }
        return connectedComponents;
    }
}