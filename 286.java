class Solution {
    
    private boolean isValid(int x, int y, int[][] rooms){
        int m=rooms.length;
        int n = rooms[0].length;
        
        if(x<0 || x>=m || y<0 || y>=n || rooms[x][y]==-1 || rooms[x][y]==0 || rooms[x][y]!=Integer.MAX_VALUE){
            return false;
        }
        
        return true;
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int m=rooms.length;
        int n = rooms[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0){
                    queue.add(new Pair(i,j));
                }
            }
        }
        
        while(queue.isEmpty() == false){
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            
            for(int i=0;i<4;i++){
                if(this.isValid(x+dx[i], y+dy[i], rooms) == true){
                    rooms[x+dx[i]][y+dy[i]] = Math.min(rooms[x+dx[i]][y+dy[i]], rooms[x][y]+1);
                    queue.add(new Pair(x+dx[i], y+dy[i]));
                }
            }
            
        }
    }
}