class Solution {
    
    private int findPathSum(int row, int col, List<List<Integer>> triangle, Map<Pair<Integer, Integer>, Integer> cache){
        Pair<Integer, Integer> pair = new Pair(row, col);
        if(cache.containsKey(pair)) return cache.get(pair);
        int path = triangle.get(row).get(col);
        if(row+1<triangle.size()){
            path+=Math.min(this.findPathSum(row+1, col,triangle, cache), this.findPathSum(row+1, col+1, triangle, cache));
        }
        cache.put(pair, path);
        return path;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {        
        return this.findPathSum(0, 0, triangle, new HashMap<Pair<Integer, Integer>, Integer>());
    }
}