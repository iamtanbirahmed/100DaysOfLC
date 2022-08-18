class Solution {
    public int minSetSize(int[] arr) {
        int target = arr.length / 2;
        Map<Integer, Integer> freq = new HashMap();
        for(int n: arr){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2)->{            
           return (e1.getValue() - e2.getValue()) *(-1); 
        });
        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            pq.offer(e);
        }
        Set<Integer> result = new HashSet();
        while(pq.isEmpty() ==false && target>0){
            Map.Entry<Integer, Integer> e = pq.poll();
            target-=e.getValue();
            result.add(e.getKey());
        }
        
        return result.size();
     }
}