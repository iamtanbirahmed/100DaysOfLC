class Solution {
    
    private int findMax(int left, int right, int[] nums){
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left+1] = Math.max(dp[left], nums[left+1]);
        for(int i=left+2;i<=right;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[right];
    }
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max1 = this.findMax(0, nums.length-2, nums);
        int max2 = this.findMax(1, nums.length-1, nums);
        
        return Math.max(max1, max2);
    }
}