class Solution {
    public int maxProfit(int[] prices) {        
        int max = 0;
        int valey = prices[0];
        for(int i=1;i<prices.length;i++){
            if(valey > prices[i]){
                valey = prices[i];
            }else{
                max = Math.max(prices[i] - valey , max);
            }
        }
        
        return max;
    }
}