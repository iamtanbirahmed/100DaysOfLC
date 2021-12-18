class Solution {
    
    private ArrayList<List<Integer>> result = new ArrayList();
    
    public void findCombination(ArrayList<Integer> currentList, int n, int k, int index, boolean[] visited){
        if(index >n || currentList.size()> k || visited[index] == true) return;        
        currentList.add(index);
        visited[index] = true;
        
        if(currentList.size() == k){
            this.result.add(new ArrayList<Integer>(currentList));
        }
        for(int i=index;i<=n;i++){
            this.findCombination(currentList, n, k, i, visited);
        }
        currentList.remove(currentList.size()-1);        
        visited[index] = false;
    }
    
    public List<List<Integer>> combine(int n, int k) {
        
        for(int i=1;i<=n;i++){
            this.findCombination(new ArrayList<Integer>(), n, k, i, new boolean[n+1]);
        }
        return this.result;
    }
}