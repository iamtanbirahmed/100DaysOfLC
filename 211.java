class TrieNode{
    HashMap<Character, TrieNode> child;
    boolean isWord;
    
    TrieNode(){
        this.child = new HashMap();
        this.isWord = false;
    }
}

class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currentHead = this.root;
        char[] chars = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char ch = chars[i];
            if(currentHead.child.containsKey(ch) == false){
                currentHead.child.put(ch, new TrieNode());
            }
            currentHead = currentHead.child.get(ch);
        }
        currentHead.isWord = true;
    }
    
    public boolean search(String word) {
        return this.searchPattern(this.root, word);
    }
    
    private boolean searchPattern(TrieNode node, String word){
        TrieNode currentHead = node;
        char[] chars = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char ch = chars[i];
            if(currentHead.child.containsKey(ch) == false){
                if(ch == '.'){
                    boolean found = false;
                    for(char key: currentHead.child.keySet()){                        
                        found = this.searchPattern(currentHead.child.get(key), word.substring(i+1));
                        if(found == true)
                            return true;
                    }
                }
                
                return false;
            }
            currentHead = currentHead.child.get(ch);
        }
        return currentHead.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */