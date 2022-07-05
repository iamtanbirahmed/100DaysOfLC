class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet();
        for(int n:nums){
            seen.add(n);
        }
        int max = 0;
        for(int n: nums){
            if(seen.contains(n-1) == false){
                int current = n;
                int len = 0;
                while(seen.contains(current)){
                    current++;
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}