class Solution {
    
    private boolean isValid(int x, int y, char[][] board){
        int m = board.length;
        int n = board[0].length;
        if(x<0 || x>=m || y<0 || y>=n || board[x][y] == '#')
            return false;
        return true;
    }
    
    private boolean findWord(int x, int y, char[][] board, int index, String word){
        if(this.isValid(x, y, board) == false || index >= word.length() || board[x][y]!=word.charAt(index)) return false;
        
        char prev = board[x][y];
        board[x][y] = '#';
        if(index == word.length() - 1)
            return true;
        
        int[] dx ={-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean found = false;
        for(int i=0;i<4;i++){
            found = this.findWord(x+dx[i], y+dy[i], board, index+1, word);
            if(found == true)
                break;
        }
        board[x][y] = prev;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean found =false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                found = this.findWord(i, j, board, 0, word);
                if(found == true)
                    return found;
            }
        }
        return found;
    }
}