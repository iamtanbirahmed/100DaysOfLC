class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            int target = nums[i]*(-1);
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{ 
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    left++;
                    while(left< right && nums[left] == nums[left-1])
                        left++;                    
                }
            }
        }
        return result;
    }
}