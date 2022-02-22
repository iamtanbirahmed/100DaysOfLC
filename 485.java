class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < nums.length){
            
            if(nums[end]!=1){
                end++;
                start = end;
                continue;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
}