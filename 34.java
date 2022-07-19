class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftMost = -1;
        int rightMost = -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                leftMost =  mid;
                right = mid-1;                
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;    
            }
        }
        left = 0;
        right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                rightMost = mid;
                left = mid+1;                
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;    
            }
        }
        
        return new int[] {leftMost, rightMost};
    }
}