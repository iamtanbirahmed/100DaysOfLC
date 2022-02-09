class TrieNode{
    
    HashMap<Character, TrieNode> children;
    boolean isWord;
    
    TrieNode(){
        this.children = new HashMap();
        this.isWord = false;
    }
    
}

class Solution {
    
    private TrieNode root;
    
    public Solution(){
        this.root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode currentHead = this.root;
        char[] chars = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char ch = chars[i];
            if(currentHead.children.containsKey(ch) == false){
                currentHead.children.put(ch, new TrieNode());
            }
            currentHead = currentHead.children.get(ch);
        }
        currentHead.isWord = true;
        
    }
    
    public String searchPrefix(){
        StringBuilder sb = new StringBuilder();
        TrieNode currentHead = this.root;
        
        while(currentHead.children.keySet().size() == 1 && currentHead.isWord == false){
            for(Character key: currentHead.children.keySet()){
                sb.append(key);
                currentHead = currentHead.children.get(key);
            }            
        }
        return sb.toString();
        
    }
    
    public String longestCommonPrefix(String[] strs) {
        for(String word: strs){
            this.insert(word);
        }
        return this.searchPrefix();
    }
}