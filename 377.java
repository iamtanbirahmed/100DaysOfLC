class Solution {
    private int findCombinations(int target, int[] nums,  Map<Integer, Integer> cache){
        if(target < 0) return 0;
        if(cache.containsKey(target) == true) return cache.get(target);
        
        if( target == 0){            
            cache.put(target, cache.getOrDefault(target,0)+1);
            return cache.get(target);
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count+=findCombinations(target-nums[i], nums, cache);          
        }
        cache.put(target, count);
        return count;
    }
    
    public int combinationSum4(int[] nums, int target) {
        // int[] cache = new int[target+1];
        
        Map<Integer, Integer> cache = new HashMap();
        return this.findCombinations(target, nums, cache);
        
    }
}