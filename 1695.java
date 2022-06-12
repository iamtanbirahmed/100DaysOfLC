class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i] = nums[i]+prefixSum[i-1];
        }
        int start = 0;
        int end = 0;
        int max = 0;
        
        while(end < nums.length){
            count.put(nums[end], count.getOrDefault(nums[end], 0)+1);
            
            while(count.get(nums[end])>1){
                int n2 = nums[start];
                count.put(n2, count.get(n2)-1);
                start++;
            }
            if(start!=0){
                max = Math.max(max, prefixSum[end]-prefixSum[start-1]);    
            }else{
                max = Math.max(max, prefixSum[end]);
            }
            
            end++;
        }
        return max;
    }
}