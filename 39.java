class Solution {
    
    private List<List<Integer>> result = new LinkedList();
    private void findCombination(LinkedList<Integer> currentList, int currentSum, int target, int index, int[] nums){
        if(index >= nums.length || currentSum > target) return ;
        if(currentSum == target){
            this.result.add(new LinkedList(currentList));
        }
        for(int i=index;i<nums.length;i++){
            currentList.add(nums[i]);
            currentSum+=nums[i];
            this.findCombination(currentList, currentSum, target, i, nums);
            currentList.removeLast();
            currentSum-=nums[i];
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.findCombination(new LinkedList<Integer>(), 0, target, 0, candidates);
        return this.result;
    }
}