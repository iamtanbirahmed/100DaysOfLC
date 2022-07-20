class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left] <= nums[right]) return nums[left];
        while(left<=right){
            int mid = left + (right -left)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] > nums[0]){
                left = mid+1;
            }else if(nums[mid] < nums[0]){
                right = mid-1;
            }
        }
        return nums[0];
    }
}