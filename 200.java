class Solution {
    private int m;
    private int n;
    
    public boolean isValid(int x, int y, char[][] grid, boolean[][] visited){
        if(x<0 || x>=this.m || y<0 || y>=this.n || visited[x][y] == true || grid[x][y] == '0'){
            return false;
        }
        return true;
    }
    
    
    public void dfs(int x, int y, char[][] grid, boolean[][] visited){
        if(this.isValid(x,y,grid,visited) == false) return;
        
        visited[x][y] = true;
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1, 1, 0,0};
        
        for(int i=0;i<4;i++){
            this.dfs(x+dx[i], y+dy[i], grid, visited);
        }
    }
    
    public int numIslands(char[][] grid) {
        this.m  = grid.length;
        this.n = grid[0].length;
                
        boolean[][] visited = new boolean[this.m][this.n];
        
        int island = 0;
        
        for(int i=0;i<this.m;i++){
            for(int j=0;j<this.n;j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    island++;
                    this.dfs(i, j, grid, visited);
                }
            }
        }
        return island;
        
    }
}