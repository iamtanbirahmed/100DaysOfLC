class Solution {
    
    private boolean isValid(int x, int y, int[][] grid, int color, int prevColor){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n|| grid[x][y] == color || grid[x][y] !=prevColor)
            return false;
        
        return true;
    }
    
    private void dfs(int x, int y, int[][] grid, int color, int prevColor){
        if(this.isValid(x, y, grid, color, prevColor) == false) return ;
        grid[x][y] = color;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i=0;i<4;i++){
            this.dfs(x+dx[i], y+dy[i], grid, color, prevColor);
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dfs(sr, sc, image, color, image[sr][sc]);
        return image;
    }
}