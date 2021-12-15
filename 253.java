class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a1, a2)->{            
           return a1[0]-a2[0]; 
        });
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a1,a2)->{            
           return a1[1]-a2[1]; 
        });
        
        minHeap.offer(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            if(minHeap.peek()[1]<=intervals[i][0]){
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);            
        }
        
        return minHeap.size();
    }
}