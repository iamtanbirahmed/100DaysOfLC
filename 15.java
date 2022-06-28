class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        
        for(int i=nums.length-1;i>=0;i--){
            int target = (-1)*nums[i];
            int left = 0;
            int right = i-1;
            
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum == target){
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    right--;
                    left++;
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        
        return new ArrayList(result);
    }
}