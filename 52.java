class Solution {
    
    private int countSolution(int row, char[][] grid, Set<Integer> column, Set<Integer> diagonal, Set<Integer> antiDiagonal, int n){
        
        if(row > n) return 0;
        if(row == n){
            return 1;
        }
        int count = 0;
        for(int col = 0;col<grid[row].length;col++){
            int diag = row+col;
            int antiDiag = row - col;
            
            if(column.contains(col) || diagonal.contains(diag) || antiDiagonal.contains(antiDiag))
                continue;
            
            column.add(col);
            diagonal.add(diag);
            antiDiagonal.add(antiDiag);
            grid[row][col] = 'Q';
            count+=this.countSolution(row+1, grid, column, diagonal, antiDiagonal, n);
            column.remove(col);
            diagonal.remove(diag);
            antiDiagonal.remove(antiDiag);
            grid[row][col] = '.';
            
        }
        return count;
        
    }
    
    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(grid[i], '.');
        }
        
        
        
        return this.countSolution(0, grid, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), n);
    }
}