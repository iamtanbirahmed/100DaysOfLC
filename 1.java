class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> count = new HashMap();
        
        for(int i=0;i<nums.length;i++){
            
            if(count.containsKey(nums[i]) == false){
                count.put(target-nums[i], i);
                continue;
            }
            result[0] = i;
            result[1] = count.get(nums[i]);
        }
        return result;
        
    }
}