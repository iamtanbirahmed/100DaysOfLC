class Solution {
    
    private boolean isValid(int x, int y, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y] != 1){
            return false;
        }
        return true;
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        queue.add(new Pair(-1,-1));
        int count = 0;
        while(queue.isEmpty() == false){
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            
            if(x < 0 || y< 0){
                if(queue.isEmpty() == false){
                    queue.add(new Pair(-1,-1));
                    count++;
                }
                continue;
                
                
            }
            
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};
            
            for(int i=0;i<4;i++){
                if(this.isValid(x+dx[i], y+dy[i], grid) == true){
                    fresh--;
                    grid[x+dx[i]][y+dy[i]] = 2;
                    queue.add(new Pair(x+dx[i], y+dy[i]));
                }
            }
        }
        
        return (fresh == 0) ? count : -1;
    }
}