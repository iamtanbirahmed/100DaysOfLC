class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new TreeMap();        
        for(String word: wordList){            
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i)+'*'+word.substring(i+1);
                if(graph.containsKey(pattern) == false){
                    graph.put(pattern, new ArrayList<String>());
                }
                graph.get(pattern).add(word);
            }             
        }
        Set<String> seen = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        seen.add(beginWord);
        int level = 0;
        
        while(queue.isEmpty() == false){
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord))
                    return level;
                for(int j=0;j<currentWord.length();j++){
                    String pattern = currentWord.substring(0,j)+'*'+currentWord.substring(j+1);
                    for(String children: graph.getOrDefault(pattern, new ArrayList<String>())){
                        if(seen.contains(children))
                            continue;
                        queue.offer(children);
                        seen.add(children);
                    }
                }
                
            }
        }
        return 0;
    }
}