class Solution {
    private ArrayList<List<Integer>> result = new ArrayList();
    private void findPermutations(LinkedList<Integer> currentList, int n, int[] nums, HashMap<Integer, Integer> count){
        if(count.get(n) == 0) return;
        currentList.add(n);
        count.put(n,count.get(n)-1);
        if(currentList.size() == nums.length){
            this.result.add(new LinkedList(currentList));
        }
        
        for(int num: count.keySet()){
            this.findPermutations(currentList, num, nums, count);
        }
        count.put(n, count.get(n)+1);
        currentList.removeLast();
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for(int n: nums){
            if(count.containsKey(n) == false){
                count.put(n, 1);
                continue;
            }
            count.put(n, count.get(n)+1);
        }
        for(int n: count.keySet()){
            this.findPermutations(new LinkedList<Integer>(),n, nums, count);    
        }
        
        return this.result;
        
    }
}