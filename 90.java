class Solution {
    
    List<List<Integer>> result = new LinkedList();
    
    private void findSubsets(LinkedList<Integer> currentList, Map<Integer, Integer> count, Integer[] nums, int index){
        
        this.result.add(new LinkedList(currentList));
        for(int i=index;i<nums.length;i++){
            int key = nums[i];
            if(count.get(key) <= 0) continue;
            count.put(key, count.get(key)-1);
            currentList.add(key);
            this.findSubsets(currentList, count, nums, i);
            count.put(key, count.get(key)+1);
            currentList.removeLast();
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        for(int n: nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }        
        Integer[] keys = count.keySet().toArray(new Integer[count.keySet().size()]);
        this.findSubsets(new LinkedList<Integer>(), count, keys, 0);        
        return this.result;
    }
}