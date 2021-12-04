class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a1, a2)->{
            if(a1[0] == a2[0]) return 0;
            else if(a1[0] < a2[0]) return -1;
            return 1;
            
        });
        
        LinkedList<int[]> merged = new LinkedList();
        merged.add(points[0]);
        for(int i=1;i<points.length;i++){
            
            if(merged.getLast()[1] >= points[i][0]){
                merged.getLast()[1] = Math.min(points[i][1], merged.getLast()[1]);
            }else{
                merged.add(points[i]);                    
            }            
        }            
            
        return merged.size();
    }
}