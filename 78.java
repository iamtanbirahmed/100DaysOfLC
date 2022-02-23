class Solution {
    
    
    private Set<List<Integer>> findSubsets(int[] nums, int index){
        Set<List<Integer>> result;
        if(index >= nums.length){
            result = new HashSet();
            result.add(new ArrayList<Integer>());
            return result;
        }else{
            result = this.findSubsets(nums, index+1);
            Set<List<Integer>> moreSets = new HashSet();
            for( List<Integer> list: result){
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[index]);
                moreSets.add(newList);
            }
            result.addAll(moreSets);
        }
        return result;
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return new ArrayList(this.findSubsets(nums, 0));
    }
}