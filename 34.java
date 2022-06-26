class Solution {
    public int[] searchRange(int[] nums, int target) {
        int key = target;
        int left = 0;
        int right = nums.length-1;
        int leftMost = -1;
        int rightMost = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int elem = nums[mid];
            if(elem == key){
                leftMost = mid;
                right = mid-1;
            }else if(elem<key){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        left = 0;
        right = nums.length-1;
            
        while(left<=right){
            int mid = left+(right-left)/2;
            int elem = nums[mid];
            if(elem == key){
                rightMost = mid;
                left = mid+1;
            }else if(elem<key){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return new int[]{leftMost, rightMost};
    }
}