class Solution {
    
    private boolean isValid(int x, int y, char[][] board){
        if(x < 0 || x>= board.length || y<0 || y>=board[0].length || board[x][y] == 'E' || board[x][y]=='X'){
            return false;
        }
        return true;
    }
    
    private void dfs(int x, int y, char[][] board){
        if(this.isValid(x,y,board) == false) return;
        board[x][y] = 'E';
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0, -1,1};
        
        for(int i=0;i<4;i++){
            this.dfs(x+dx[i], y+dy[i], board);
        }
        
    }
    
    public void solve(char[][] board) {
        HashSet<Pair<Integer, Integer>> border = new HashSet();
        for(int i=0;i<board.length;i++){
            border.add(new Pair(i,0));
            border.add(new Pair(i, board[0].length-1));
        }
        
        for(int j=0; j< board[0].length;j++){
            border.add(new Pair(0,j));
            border.add(new Pair(board.length-1, j));
        }
        
        for(Pair<Integer, Integer> coord: border){
            this.dfs(coord.getKey(), coord.getValue(), board);
        }
        
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
}