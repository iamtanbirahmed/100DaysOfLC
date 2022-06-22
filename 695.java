class Solution {
    
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0|| x>=m || y<0 || y>=n|| grid[x][y]==0){
            return false;
        }
        return true;
    }
    
    private int dfs(int x, int y, int[][] grid, int currentArea){
        if(this.isValid(x, y, grid) == false) return currentArea;
        grid[x][y] = 0;        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for(int i=0;i<4;i++){
            currentArea = this.dfs(x+dx[i], y+dy[i], grid, currentArea);
        }
        return ++currentArea;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){                
                if(grid[i][j]==1){
                    Integer currentArea = 0;
                    currentArea = this.dfs(i, j, grid, currentArea);
                    max = Math.max(max, currentArea);
                }
            }
        }
        
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}