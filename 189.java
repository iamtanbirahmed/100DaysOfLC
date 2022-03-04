class Solution {
    private void reverse(int left, int right, int[] nums){
        while(left<=right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k = (k)%nums.length;
        this.reverse(0, nums.length-1, nums);
        this.reverse(0, k-1, nums);
        this.reverse(k, nums.length-1, nums);
    }
}