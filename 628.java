class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int pos = nums[length-1]*nums[length-2]*nums[length-3];
        int neg = nums[0]*nums[1]*nums[length-1];
        return Math.max(pos, neg);
    }
}