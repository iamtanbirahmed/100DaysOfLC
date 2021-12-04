class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        
        Arrays.sort(intervals, (a1, a2)->{
           return a1[0] - a2[0]; 
        });
        
        LinkedList<int[]> mergedIntervals = new LinkedList();
        mergedIntervals.addLast(intervals[0]);
        for(int i=1;i < intervals.length;i++){
            int[] latest = mergedIntervals.getLast();
            if(latest[1] >= intervals[i][0]){
                mergedIntervals.getLast()[1] = Math.max(latest[1],intervals[i][1]);
            }else{
                mergedIntervals.add(intervals[i]);
            }
            
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        
        
    }
}