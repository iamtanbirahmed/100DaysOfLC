class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2)->{
            
            return (int)e1.getValue() -(int)e2.getValue();
        });
        
        for(int n1: nums){
            if(count.containsKey(n1) == false){
                count.put(n1,0);
            }
            count.put(n1, count.get(n1)+1);
        }
        
        for(Map.Entry<Integer, Integer> e: count.entrySet()){
            minHeap.add(e);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int[] result = new int[k];
        int i=0;
        while(minHeap.isEmpty() == false){
            result[i] = minHeap.poll().getKey();
            i++;
        }
        
        return result;
    }
}