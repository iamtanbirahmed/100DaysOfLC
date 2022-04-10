class Solution {
    public int maxProfit(int[] prices) {
        int peak = prices[0];
        int valey = prices[0];
        int total = 0;
        for(int i=1;i<prices.length;i++){
            if(peak > prices[i]){
                total+=(peak-valey);
                peak = prices[i];
                valey = prices[i];
            }else{
                peak = prices[i];
            }
        }
        
        total+=(peak-valey);
        
        return total;
    }
}