class Solution {
    private int count = 0;
    
    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited ){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0|| y>=n || visited[x][y] == true || grid[x][y] == -1){
            return false;
        }
        return true;
        
    }
    
    private void findPath(int x, int y, int[][] grid, boolean[][] visited, int nonObstacle){
        if(this.isValid(x, y, grid, visited) == false) return;
        visited[x][y] = true;
        nonObstacle--;
        if(grid[x][y] == 2 && nonObstacle == 0){
            this.count++;
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        for(int i=0;i<4;i++){
            this.findPath(x+dx[i], y+dy[i], grid, visited, nonObstacle);
        }
        visited[x][y] = false;
        nonObstacle++;
        
    }
    public int uniquePathsIII(int[][] grid) {
        int[] source = new int[2];
        int nonObstacle = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j] == 1){
                    source = new int[] {i,j};
                }
                if(grid[i][j] >=0){
                    nonObstacle++;
                }                
            }
        }
        
        this.findPath(source[0], source[1], grid, new boolean[m][n], nonObstacle);
        return this.count;
    }
}