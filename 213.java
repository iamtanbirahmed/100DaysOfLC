class Solution {
    
    private int findMax(int left, int right, int[] nums){
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left+1] = Math.max(dp[left], nums[left+1]);
        for(int i=left+2;i<=right;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[right];
    }
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max_1 = this.findMax(0, nums.length-2, nums);
        int max_2 = this.findMax(1, nums.length-1, nums);
        
        return Math.max(max_1, max_2);
    }
}