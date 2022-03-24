class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int n: nums){
            set.add(n);           
        }
        
        int max = 0;
        int end = 0;
        while(end< nums.length){
            if(set.contains(nums[end]-1) == false){
                int currentNum = nums[end];
                int count = 0;
                while(set.contains(currentNum) == true){
                    count++;
                    currentNum++;
                }
                max = Math.max(max, count);
                
            }
            end++;
        }        
        return max;
    }
}