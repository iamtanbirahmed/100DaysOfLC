class Solution {
    
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0){
            return false;
        }
        return true;
    }
    
    private int countArea(int x, int y, int[][] grid, int count){
        if(this.isValid(x, y, grid) == false) return count;
        grid[x][y] = 0;
        count++;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<4;i++){
            count= this.countArea(x+dx[i], y+dy[i], grid, count);
        }
        return count;
    }
    
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for( int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, this.countArea(i,j, grid, 0));
                }
            }
        }
        return maxArea;
    }
}