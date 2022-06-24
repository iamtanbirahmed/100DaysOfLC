class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap();
        Map<Integer, Set<Integer>> col = new HashMap();
        Map<Pair<Integer, Integer>, Set<Integer>> squares = new HashMap();
        for(int i=0;i<9;i++){
            row.put(i, new HashSet<Integer>());
            col.put(i, new HashSet<Integer>());
            for(int j=0;j<9;j++){
                if(squares.containsKey(new Pair(i/3, j/3)) == false)
                    squares.put(new Pair(i/3, j/3), new HashSet<Integer>());
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int val = board[i][j];
                if(val == '.')
                    continue;
                if(row.get(i).contains(val) || col.get(j).contains(val) || squares.get(new Pair(i/3,j/3)).contains(val))
                    return false;
                row.get(i).add(val);
                col.get(j).add(val);
                squares.get(new Pair(i/3, j/3)).add(val);
            }
        }
        return true;
    }
}