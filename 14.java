class TrieNode{
    
    Map<Character, TrieNode> children;
    boolean isWord;
    
    TrieNode(){
        this.children = new HashMap();
        this.isWord = false;
    }
    
}


class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        
        TrieNode root  = new TrieNode();
        for(String str: strs){
            TrieNode currentNode = root;
            for(char ch: str.toCharArray()){
                if(currentNode.children.containsKey(ch) == false){
                    currentNode.children.put(ch, new TrieNode());
                }
                currentNode = currentNode.children.get(ch);
            }
            currentNode.isWord = true;
        }
        
        StringBuilder sb = new StringBuilder();
        TrieNode currentNode = root;
        while(currentNode.children.size() == 1 && currentNode.isWord == false){
            for(char ch: currentNode.children.keySet()){
                sb.append(ch);
                currentNode  = currentNode.children.get(ch);
            }
        }
        return sb.toString();
    }
}