class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2)->{
            if(a1[0] == a2[0]){
                return Integer.compare(a1[1], a2[1]);
            }
            return Integer.compare(a1[0], a2[0]);
        });
        int prev = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            // check for overlap
            if(prev > intervals[i][0]){
                prev = Math.min(prev, intervals[i][1]);
                count++;
                continue;
            }
            prev = intervals[i][1];
        }
        return count;
    }
}