class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2)->{
           return n2-n1; 
        });
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}