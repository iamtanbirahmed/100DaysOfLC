class Solution {
    
    private List<List<Integer>> result = new ArrayList();
    private HashMap<Integer, Integer> count = new HashMap();
    
    private void findCombination(LinkedList<Integer> currentList, int currentSum, int index, Integer[] nums, int target){
        if(index>=nums.length || currentSum > target || this.count.get(nums[index]) == 0)return;
        this.count.put(nums[index], this.count.get(nums[index])-1);
        currentList.add(nums[index]);
        
        if(currentSum+nums[index] == target){
            this.result.add(new LinkedList(currentList));
        }
        
        for(int i=index;i<nums.length;i++){
            this.findCombination(currentList, currentSum+nums[index], i, nums, target);
        }
        this.count.put(nums[index], this.count.get(nums[index])+1);
        currentList.removeLast();
        
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        for(int n: candidates){
            this.count.put(n, this.count.getOrDefault(n,0)+1);
        }
        
        Integer[] nums = this.count.keySet().toArray(new Integer[this.count.keySet().size()]);
        
        for(int i=0;i<nums.length;i++){
            this.findCombination(new LinkedList<Integer>(), 0, i, nums, target);
        }
        return this.result;
    }
}