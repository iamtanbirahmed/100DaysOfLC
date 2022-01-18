class MedianFinder {
    
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>((n1,n2)->{
           return Integer.compare(n1,n2); 
        });
        this.maxHeap = new PriorityQueue<Integer>((n1,n2)->{
           return Integer.compare(n1,n2)*(-1); 
        });
    }
    
    public void addNum(int num) {
        this.maxHeap.offer(num);
        int max = this.maxHeap.poll();
        this.minHeap.offer(max);
        if( this.minHeap.size() - this.maxHeap.size() > 1){
            int min = this.minHeap.poll();
            this.maxHeap.offer(min);
        }
    }
    
    public double findMedian() {
        if(this.maxHeap.size() == this.minHeap.size()){
            return new Double(this.maxHeap.peek()+this.minHeap.peek())/2;
        }
        return this.minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */