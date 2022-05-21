class Solution {
    
    private List<List<Integer>> result =new LinkedList();;
    
    private void findPermutations(LinkedList<Integer> currentList, Map<Integer, Integer> count, int length){
        if(currentList.size() > length) return;
        if(currentList.size() == length){
            this.result.add(new LinkedList(currentList));
        }
        
        for(int n: count.keySet()){
            if(count.get(n) <= 0 )
                continue;
            count.put(n, count.get(n)-1);
            currentList.add(n);
            this.findPermutations(currentList, count, length);
            count.put(n, count.get(n)+1);
            currentList.removeLast();
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        for(int n: nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }
        
        this.findPermutations(new LinkedList<Integer>(), count, nums.length); 
        return this.result;
    }
}