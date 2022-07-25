class Solution {
    
    private List<List<Integer>> result = new LinkedList();
    
    private void findSubSets(LinkedList<Integer> currentList, Map<Integer, Integer> count, int index, Integer[] nums){
        this.result.add(new LinkedList(currentList));
        for(int i=index;i<nums.length;i++){
            if(count.get(nums[i])<=0)
                continue;
            count.put(nums[i], count.get(nums[i])-1);
            currentList.add(nums[i]);
            this.findSubSets(currentList, count, i, nums);
            count.put(nums[i], count.get(nums[i])+1);
            currentList.removeLast();
            
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        Integer[] keys = count.keySet().toArray(new Integer[count.size()]);
        this.findSubSets(new LinkedList<Integer>(), count, 0, keys);
        return this.result;
    }
}