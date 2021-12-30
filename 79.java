class Solution {
    
    private boolean isValid(int x, int y, char[][] board, boolean[][] visited){
        if(x <0 || x>= board.length || y<0 || y>= board[0].length || visited[x][y] == true){
            return false;
        }
        return true;
    }
    
    
    public boolean searchWord(int x, int y, char[][] board, int index, String word, boolean[][] visited) {
        if(this.isValid(x, y, board, visited) == false || index >= word.length() || word.charAt(index)!= board[x][y]){
            return false;
        }
        if(index == word.length()-1)
            return true;
        visited[x][y] = true;
        index++;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        boolean found = false;        
        for(int i=0;i<4;i++){
            found  = this.searchWord(x+dx[i], y+dy[i], board, index, word, visited);
            if(found == true){
                break;
            }
        }
        index--;
        visited[x][y] =false;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[0].length;j++){
                found = this.searchWord(i,j, board, 0, word, new boolean[board.length][board[0].length]);
                if (found == true){
                    return true;
                } 
            }
        }
        return found;
    }
}