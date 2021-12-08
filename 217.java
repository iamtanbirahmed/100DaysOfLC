class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n: nums){
            if(count.containsKey(n) == false){
                count.put(n, 0);
            }
            count.put(n, count.get(n)+1);
        }
        for(Integer c: count.values()){
            if(c >=2) return true;
        }
        return false;
    }
}