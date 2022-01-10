class Solution {
    
    private int findRotatePivot(int[] nums){
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right]) return -1;
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] > nums[mid+1])
                return mid;
            if(nums[mid-1] > nums[mid])
                return mid-1;
            if(nums[mid] > nums[0]){
                left = mid+1;
            }else if(nums[mid] < nums[0]){
                right = mid-1;
            }
        }
        
        return -1;
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivotIndex = this.findRotatePivot(nums);
        if(pivotIndex <0){
            return this.binarySearch(nums, 0, nums.length-1, target);
        }
        int left = this.binarySearch(nums, 0, pivotIndex, target);
        int right = this.binarySearch(nums, pivotIndex+1, nums.length-1, target);
        return left>=0? left:right;
    }
}