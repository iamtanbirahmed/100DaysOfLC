class Solution {
    public void dfs(int start, int[][] isConnected, boolean[] visited){
        if(visited[start] == true) return;
        visited[start] = true;
        for(int j=0;j<isConnected[start].length;j++){
            if(isConnected[start][j] == 1){
                this.dfs(j, isConnected, visited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                provinces++;
                this.dfs(i, isConnected, visited);
            }
        }
       
        return provinces;
        
    }
}