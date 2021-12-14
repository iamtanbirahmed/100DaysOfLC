class Solution {
    
    private List<List<Integer>> result = new LinkedList();
    
    public void findCombination(LinkedList<Integer> currentList, int[] candidates, int index, int target, int currentSum){
        if(index >= candidates.length) return;
        
        if(currentSum+candidates[index] > target)
            return;
        
        currentList.add(candidates[index]);
        if(currentSum+candidates[index] == target){
            LinkedList<Integer> tmp = new LinkedList(currentList);
            result.add(tmp);
        }
        for(int i=index;i<candidates.length;i++){
            this.findCombination(currentList, candidates, i, target, currentSum+candidates[index]);    
        }
        
        currentList.removeLast();
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int i=0;i<candidates.length;i++){
            this.findCombination(new LinkedList<Integer>(), candidates, i, target, 0);    
        }
        
        return result;
    }
}