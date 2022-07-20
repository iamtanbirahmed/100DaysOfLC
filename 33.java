class Solution {
    private int findPivotIndex(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;            
            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }else if(nums[mid] < nums[mid-1]){
                return mid;
            }else if(nums[mid] > nums[0]){
                left = mid+1;
            }else if(nums[mid] < nums[0]){
                right = mid - 1;
            }             
        }
        return -1;        
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if(nums[0] <= nums[nums.length-1])
            return this.binarySearch(nums, 0, nums.length-1, target);
        
        int pivotIndex = this.findPivotIndex(nums);
        int leftHalfIndex = this.binarySearch(nums, 0, pivotIndex-1, target);
        return leftHalfIndex >=0 ? leftHalfIndex : this.binarySearch(nums, pivotIndex, nums.length-1, target);
    }
}