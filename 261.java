class Solution {
    
    private HashMap<Integer, Integer> parent = new HashMap();
    private Set<Integer> visited = new HashSet();
    public boolean dfs(int root, ArrayList<Integer>[] graph){
        this.visited.add(root);
        boolean found = true;
        for(int child: graph[root]){
            if(this.parent.get(root) == child){
                continue;
            }
            if(this.visited.contains(child))
                return false;
            
            this.parent.put(child, root);
            found = this.dfs(child, graph);
            if(found == false)
                break;            
        }
        return found;
    }
    
    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        this.parent.put(0, -1);
        // this.visited.add(0);
        
        boolean found = this.dfs(0, graph);
        
        if(found == false || this.visited.size() != n){
            return false;
        }
        return true;
        
    }
}