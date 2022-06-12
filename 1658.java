class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> prefixSum = new HashMap();
        int total = 0;
        for(int n: nums){
            total+=n;
        }
        total-=x;
        if(total == 0) return nums.length;
        int len = Integer.MIN_VALUE;
        int currentSum = 0;
        prefixSum.put(0,-1);
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(currentSum == total)
                len = Math.max(len, i+1);
            int key = currentSum-total;
            if(prefixSum.containsKey(key)){
                len =Math.max(len, i - prefixSum.get(key));
            }
            prefixSum.put(currentSum, i);
        }
        
        return (len == Integer.MIN_VALUE)? -1 : (nums.length-len) ;
    }
}