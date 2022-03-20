class TrieNode{
    HashMap<Character, TrieNode> children;
    String isWord;
    
    TrieNode(){
        this.children = new HashMap();
        this.isWord = null;
    }
    
}

class Solution {
    
    private List<String> result = new ArrayList();
    
    private boolean isValid(int x, int y, char[][] board, boolean[][] visited){
        int m = board.length;
        int n = board[0].length;
        if(x<0 || x>=m || y<0 || y>=n || visited[x][y] == true){
            return false;
        }
        
        return true;
    }
    
    private void checkWords(int x, int y, char[][] board, TrieNode node, boolean[][] visited){
        if(this.isValid(x, y, board, visited) == false || node.children.containsKey(board[x][y]) == false) return;
        char ch = board[x][y];
        visited[x][y] = true;
        TrieNode prev = node;
        node = node.children.get(ch);
        if(node.isWord != null){
            this.result.add(new String(node.isWord));
            node.isWord = null;
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        for(int i=0;i<4;i++){
            this.checkWords(x+dx[i], y+dy[i], board, node, visited);
        }
        
        visited[x][y] = false;
        node = prev;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        
        for(String word: words){
            TrieNode currentHead = root;
            char[] chars = word.toCharArray();
            for(char ch: chars){
                if(currentHead.children.containsKey(ch) == false){
                    currentHead.children.put(ch, new TrieNode());
                }
                currentHead = currentHead.children.get(ch);
            }
            currentHead.isWord = word;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                this.checkWords(i, j, board, root, new boolean[m][n]);
            }
        }
        
        return this.result;
        
    }
}