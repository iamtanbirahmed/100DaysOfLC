class Solution {
    
    private List<List<String>> result = new LinkedList();
    
    private List<String> convertBoardToString(char [][] graph){
        List<String> board = new LinkedList();
        for(int i=0;i<graph.length;i++){
            board.add(new String(graph[i]));
        }
        
        return board;
    }
    
    
    private void findSolution(int row, int size, Set<Integer> column, Set<Integer> diagonal, Set<Integer> antiDiagonal, char[][] graph){
        
        if(row>size) return;
        if(row == size){
            this.result.add(convertBoardToString(graph));
            return;
        }
        
        for(int i=0;i<graph[row].length;i++){
            int col= i;
            int diag = row+col;
            int antiDiag = row-col;
            if(column.contains(col) || diagonal.contains(diag) || antiDiagonal.contains(antiDiag) || graph[row][col] == 'Q')
                continue;
            graph[row][col] = 'Q';
            column.add(col);
            diagonal.add(diag);
            antiDiagonal.add(antiDiag);
            
            this.findSolution(row+1, size, column, diagonal, antiDiagonal, graph);
            
            graph[row][col] = '.';
            column.remove(col);
            diagonal.remove(diag);
            antiDiagonal.remove(antiDiag);
            
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] graph = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i], '.');
        }
        
        this.findSolution(0, n, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), graph);
        
        return this.result;
    }
}