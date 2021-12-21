class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2)->{
           return Integer.compare(n1,n2); 
        });
        
        for(int n:nums){
            pq.offer(n);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.poll();
    }
}