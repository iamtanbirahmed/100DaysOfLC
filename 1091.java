class Solution {
    
     
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[m-1][n-1] == 1 || grid[0][0] == 1) return -1;
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.offer(new Pair(0,0));
        grid[0][0] = 1;
        int[] dx = {1,1,1,-1,-1,-1,0,0};
        int[] dy = {-1,0,1,-1,0,1,-1,1};
        
        while(queue.isEmpty() == false){
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            
            if(x == m-1 && y == n-1)
                return grid[x][y];
            
            for(int i=0;i<8;i++){
                int X = x+dx[i];
                int Y = y+dy[i];
                if(X<0 || X>=m || Y<0 || Y>=n || grid[X][Y] !=0){
                    continue;
                }
                grid[X][Y] = grid[x][y]+1;
                queue.offer(new Pair(X,Y));
            }
        }
        
        return -1;
    }
}