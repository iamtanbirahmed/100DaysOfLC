class TrieNode{
    HashMap<Character, TrieNode> child;
    boolean isEnd;
    
    TrieNode(){
        this.child = new HashMap();
        this.isEnd = false;
    }
    
}

class Trie {
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentNode = this.root;
        for(char ch: chars){
            if(currentNode.child.get(ch) == null){
                currentNode.child.put(ch, new TrieNode());
            }
            currentNode = currentNode.child.get(ch);
        }
        currentNode.isEnd = true;
        
    }
    
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentNode = this.root;
        for(char ch: chars){
            if(currentNode.child.get(ch) == null){
                return false;
            }
            currentNode = currentNode.child.get(ch);
        }
        if(currentNode!=null && currentNode.isEnd == false){
            return false;
        }
        return true;
        
    }
    
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode currentNode = this.root;
        for(char ch: chars){
            if(currentNode.child.get(ch) == null){
                return false;
            }
            currentNode = currentNode.child.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */