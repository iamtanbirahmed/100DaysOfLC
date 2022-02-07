class KthLargest {
    
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    private int size;
    

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for(int n: nums){
            this.add(n);
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(pq.size()>this.size){
            pq.poll();
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */