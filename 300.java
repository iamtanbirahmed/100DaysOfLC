class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}