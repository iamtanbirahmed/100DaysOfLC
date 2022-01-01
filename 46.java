class Solution {
    
    private ArrayList<List<Integer>> result = new ArrayList();
    
    private void findPermutations(LinkedList<Integer> currentList, int index, int[] nums, HashMap<Integer, Boolean> visited){
        if(index >= nums.length || (visited.containsKey(nums[index]) && visited.get(nums[index]) == true)) return;
        visited.put(nums[index], true);
        currentList.add(nums[index]);
        if(currentList.size() == nums.length){
            this.result.add(new LinkedList(currentList));
        }
        for(int i=0;i<nums.length;i++){
            this.findPermutations(currentList, i, nums, visited);            
        }
        currentList.removeLast();
        visited.put(nums[index], false);
    } 
    
    public List<List<Integer>> permute(int[] nums) {
        for(int i=0;i<nums.length;i++){
            this.findPermutations(new LinkedList<Integer>(), i, nums, new HashMap<Integer, Boolean>());
        }
        
        return this.result;
    }
}