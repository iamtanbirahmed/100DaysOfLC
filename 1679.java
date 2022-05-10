class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int count= 0;
        while(left < right){            
            int val = nums[left]+nums[right];
            if(k > val){
                left ++;
            }else if(k < val){
                right --;
            }else{
                count++;
                left++;
                right--;
            }
        }
        
        return count;
    }
}