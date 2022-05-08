class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a1, a2)->{
            return (a1[0]-a1[1]) - (a2[0]-a2[1]);
        });
        int n = costs.length;
        int total = 0;
        for(int i=0;i<costs.length;i++){
            if(i < n/2){
                total+=costs[i][0];
            }else{
                total+=costs[i][1];
            }
        }
        
        return total;
    }
}