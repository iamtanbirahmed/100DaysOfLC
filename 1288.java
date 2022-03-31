class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2)->{           
            return (a1[0] == a2[0])? Integer.compare(a1[1], a2[1])*(-1) : Integer.compare(a1[0], a2[0]);
        });
        
        int count = 0;
        int prev = Integer.MIN_VALUE;
        
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1] > prev){
                count++;
                prev = intervals[i][1];
            }
        }
        
        return count;
    }
}