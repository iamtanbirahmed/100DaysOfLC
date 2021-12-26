class TrieNode{
    HashMap<Character, TrieNode> child;
    String word;
    
    TrieNode(){
        this.child = new HashMap();
        this.word = null;
    }
}

class PrefixTree{
    
    TrieNode root;
    
    PrefixTree(){
        this.root = new TrieNode();
    }
    
    void insert(String word){
        TrieNode currentHead = this.root;
        char[] chars = word.toCharArray();
        for(char ch: chars){
            if(currentHead.child.containsKey(ch) == false){
                currentHead.child.put(ch, new TrieNode());
            }
            currentHead = currentHead.child.get(ch);
        }
        currentHead.word = word;
    }
    
    String replace(String word){
        TrieNode currentHead = this.root;
        char[] chars = word.toCharArray();
        for(char ch: chars){
            if(currentHead.child.containsKey(ch) == false || currentHead.child.get(ch).word != null){
                return currentHead.child.containsKey(ch) == false ? word: currentHead.child.get(ch).word; 
            }
            currentHead = currentHead.child.get(ch);
        }
        return word;
    }

}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        PrefixTree pt = new PrefixTree();
        for(String root: dictionary){
            pt.insert(root);
        }
        StringBuilder sb = new StringBuilder();
        for(String word: sentence.split(" ")){
            sb.append(pt.replace(word)+" ");            
        }
        return sb.toString().strip();
    }
}