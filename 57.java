class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalList = new ArrayList();
        for(int[] interval: intervals){
            intervalList.add(interval);
        }
        intervalList.add(newInterval);
        intervalList.sort((a1,a2)->{
            return (a1[0]-a2[0]);
        });
        
        ArrayList<int[]> result = new ArrayList();
        for(int[] interval: intervalList){
            if(result.size() == 0){
                result.add(interval);
                continue;
            }
            int[] last = result.get(result.size()-1);
            if(last[1]>= interval[0]){
                result.get(result.size()-1)[1] = Math.max(last[1], interval[1]);
            }else{
                result.add(interval);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}