class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exp = ((n+1-1)*(n+2-1))/2;
        
        for(int i=0;i<n;i++){
            exp= exp - nums[i];
        }
        return exp;
    }
}