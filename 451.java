class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((e1,e2)->{
           return (int)e2.getValue()-(int)e1.getValue(); 
        });
        
        for(char ch: chars){
            if(count.containsKey(ch) == false){
                count.put(ch, 0);
            }
            count.put(ch, count.get(ch)+1);
        }
        
        for(Map.Entry<Character, Integer> e: count.entrySet()){
            maxHeap.add(e);
        }
        StringBuilder result = new StringBuilder();
        while(maxHeap.isEmpty() == false){
            
            Map.Entry<Character, Integer> e = maxHeap.poll();
            result.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }
        return result.toString();
        
    }
}