class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        while(left<right){
            int width = right-left;
            max = Math.max(max, width*Math.min(height[left], height[right]));
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        
        return max;
    }
}