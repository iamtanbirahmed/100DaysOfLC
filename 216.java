class Solution {
    
    private ArrayList<List<Integer>> result = new ArrayList();
    
    private void findCombinations(LinkedList<Integer> currentList, int currentSum, int index, boolean[] visited, int size, int target){
        if(currentSum > target || visited[index] == true || currentList.size() > size || index > 9) return;
        currentList.add(index);
        visited[index] = true;
        if(currentList.size() == size && (currentSum+index) == target){
            this.result.add(new LinkedList(currentList));
        }
        for(int i=index;i<=9;i++){
            this.findCombinations(currentList, currentSum+index, i, visited, size, target);
        }
        visited[index] = false;
        currentList.removeLast();
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        for(int i=1;i<=9;i++){
            this.findCombinations(new LinkedList(), 0, i, new boolean[10], k, n);
        }
        return this.result;
    }
}