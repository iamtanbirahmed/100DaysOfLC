class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>((a1, a2)->{
            return a1-a2;
        });
        
        for(int n: nums){
            heap.offer(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        return heap.peek();
    }
}