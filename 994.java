class Solution {
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0|| x>=m || y<0 || y>=n || grid[x][y]!=1){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    freshOrange++;                    
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int min = 0;
        queue.offer(new int[] {-1,-1});
        while(queue.isEmpty() == false){
            int[] src = queue.poll(); 
            int x = src[0];
            int y = src[1];
            if(x == -1 && y==-1){
                if(queue.isEmpty() == true)
                    break;
                min++;
                queue.offer(new int[]{-1,-1});
                continue;
            }
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            for(int i=0;i<4;i++){
                int X = x+dx[i];
                int Y = y+dy[i];
                if(this.isValid(X,Y, grid) == false){
                    continue;
                }
                grid[X][Y] = 2;
                freshOrange--;
                queue.offer(new int[]{X,Y});
            }
            
        }
        
        return (freshOrange == 0) ? min : -1;
    }
}