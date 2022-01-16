class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap();
        
        int currentSum = 0;
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(currentSum == k){
                count++;                
            }
            if(prefixSumCount.containsKey(currentSum-k)){
                count+=prefixSumCount.get(currentSum-k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}