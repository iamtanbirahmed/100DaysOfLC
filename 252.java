class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <=1) return true;
        Arrays.sort(intervals, (a1, a2)->{            
           return a1[0] - a2[0]; 
        });
        
        LinkedList<int[]> mergedIntervals = new LinkedList();
        mergedIntervals.add(intervals[0]);
        
        for(int i=1 ; i<intervals.length ;i++ ){
            if(mergedIntervals.getLast()[1] > intervals[i][0]){
                return false;
            }else{
                mergedIntervals.add(intervals[i]);
            }
        }
        
        return true;
    }
}