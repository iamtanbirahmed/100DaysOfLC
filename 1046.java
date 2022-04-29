class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2)->{
            return n2-n1;
        });
        for(int n: stones){
            minHeap.offer(n);
        }
        
        while(minHeap.size() > 1){
            int y = minHeap.poll();
            int x = minHeap.poll();
            if(x == y)
                continue;
            minHeap.offer(y-x);
        }
        
        return minHeap.size()>0 ? minHeap.peek() : 0;
    }
    
}