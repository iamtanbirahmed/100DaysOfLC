class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count  = new HashMap();
        for(String word: words){
            if(count.containsKey(word) == false){
                count.put(word, 1);
                continue;
            }
            count.put(word, count.get(word)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((e1, e2)->{
            
            if(e1.getValue() == e2.getValue()){
                return e1.getKey().compareTo(e2.getKey())*(-1);
            }
            return (e1.getValue()-e2.getValue());
            
        });
        
        for(Map.Entry<String, Integer> e: count.entrySet()){
            pq.offer(e);
            if(pq.size()> k){
                pq.poll();
            }
        }
        
        ArrayList<String> result = new ArrayList();
        while(pq.isEmpty() == false){
            Map.Entry<String, Integer> e = pq.poll();
            result.add(e.getKey());
        }
        Collections.reverse(result);
        
        return result;
    }
}