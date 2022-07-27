class Solution {
    
    private boolean isValid(char[][] board, int x, int y){
        int m = board.length;
        int n = board[0].length;
        if(x<0 || x>=m || y<0 || y>=n || board[x][y] == '#')
            return false;
        
        return true;
    }
    
    private boolean findWord(char[][] board, int x, int y, int index, String word){
        if(this.isValid(board, x, y) == false || index>= word.length()|| word.charAt(index)!= board[x][y]) return false;        
        if(index == word.length()-1){
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '#';
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean found = false;
        
        for(int i=0;i<4;i++){
            found = this.findWord(board, x+dx[i], y+dy[i], index+1, word);
            if(found == true)
                break;
        }
        board[x][y] = tmp;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean found = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                found = this.findWord(board, i, j, 0, word);
                if(found == true)
                    return true;
            }
        }
        
        return false;
    }
}