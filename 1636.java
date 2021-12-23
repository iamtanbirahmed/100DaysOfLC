class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for(int n: nums){
            if(count.containsKey(n) == false){
                count.put(n, 1);
                continue;
            }
            count.put(n, count.get(n)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2)->{              if(e1.getValue() == e2.getValue()){
            return Integer.compare(e1.getKey(), e2.getKey())*(-1);
        }
            return Integer.compare(e1.getValue(), e2.getValue());
        });
        
        for(Map.Entry<Integer, Integer> e: count.entrySet()){
            pq.offer(e);
        }
        
        ArrayList<Integer> result = new ArrayList();
        while(pq.isEmpty() == false){
            Map.Entry<Integer, Integer> e = pq.poll();
            int repeat = e.getValue();
            while(repeat>0){
                result.add(e.getKey());
                repeat--;
            }
        }
        
        int[] finalResult = new int[result.size()];
        for(int i=0;i<result.size();i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}