class Solution {
    
    private int findCount(int index, int[] nums, int target, HashMap<Integer, Integer> memo){
        if(index >= nums.length || target < 0 ) return 0;
        target = target - nums[index];
        if(target  == 0){
            return 1;
        }
        if(memo.containsKey(target) == true) return memo.get(target);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count+=this.findCount(i, nums, target, memo);
        }
        memo.put(target, count);
        target+=nums[index];
        return count;
    }
    
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        HashMap<Integer, Integer> memo = new HashMap();
        for(int i=0;i<nums.length;i++){
            count+=this.findCount(i, nums, target, memo);
        }
        return count;
    }
}