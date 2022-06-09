class Solution {
    
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]!=0)
            return false;
        
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;
        
        while(queue.isEmpty() == false){
            int[] node = queue.poll();
            
            int[] dx = {-1,-1,-1,0,0,1,1,1};
            int[] dy = {-1,0,1,-1,1,-1,0,1};
            
            if(node[0] == grid.length-1 && node[1] == grid[0].length-1)
                    return grid[node[0]][node[1]];
            
            for(int i=0;i<8;i++){
                int X = node[0]+dx[i];
                int Y = node[1]+dy[i];                
                if(this.isValid(X,Y, grid)){
                    grid[X][Y]=grid[node[0]][node[1]]+1;
                    queue.offer(new int[]{X,Y});
                }
            }            
        }
        
        return -1;
    }
}