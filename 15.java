class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            int target = nums[i]*(-1);
            while(left<right){
                if(nums[left]+nums[right] > target){
                    right--;
                }else if(nums[left]+nums[right]< target){
                    left++;
                }else{
                    ArrayList<Integer> sln = new ArrayList();
                    sln.addAll(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(sln);
                    right--;
                    left++;
                }
            }
            
        }
        return new ArrayList(result);
    }
}