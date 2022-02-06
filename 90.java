class Solution {
    
    private List<List<Integer>> result = new ArrayList();
    
    private void findPermutations(LinkedList<Integer> currentList, int index, Integer[] nums, HashMap<Integer, Integer> count){
        if(index>=nums.length || count.get(nums[index]) == 0) return;
        currentList.add(nums[index]);
        count.put(nums[index], count.get(nums[index])-1);
        this.result.add(new LinkedList<Integer>(currentList));
        for( int i=index;i<nums.length;i++){
            this.findPermutations(currentList, i, nums, count);
        }
        currentList.removeLast();
        count.put(nums[index], count.get(nums[index])+1);
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for(int n: nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }
        
        this.result.add(new LinkedList<Integer>());
        
        Integer[] keys = count.keySet().toArray(new Integer[count.keySet().size()]);
        for( int i=0;i<keys.length;i++){
            this.findPermutations(new LinkedList<Integer>(), i, keys, count);
        }
        
        return this.result;
    }
}