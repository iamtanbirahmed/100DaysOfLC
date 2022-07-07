class Solution {
    
    private boolean isValid(int x, int y, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == '#')
            return false;
        return true;
    }
    
    private boolean findWord(int index, int x, int y, char[][] grid, String word){
        if(this.isValid(x, y, grid) == false || index>=word.length()) return false;
        if(word.charAt(index)!= grid[x][y]) return false;
        if(index == word.length()-1) return true;
        
        boolean found = false;
        char prev = grid[x][y];
        grid[x][y] = '#';
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i=0;i<4;i++){
            found = this.findWord(index+1, x+dx[i], y+dy[i], grid, word);
            if(found == true)
                break;
        }
        grid[x][y] = prev;
        return found;
        
    }
    
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                found = this.findWord(0, i, j, board, word);
                if(found == true)
                    return true;
            }
        }
        
        return false;
    }
}