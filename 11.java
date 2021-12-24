class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        
        while(left < right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = currentHeight*(right-left);
            
            max = Math.max(currentArea, max);
            
            if(height[left]< height[right] ){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}