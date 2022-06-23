class Solution {
    
    private int countWays(int n, Map<Integer, Integer> cache){
        if(n <= 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);
        int result = countWays(n-2, cache) + countWays(n-1, cache);;
        cache.put(n, result);
        return result;
    }
    
    public int climbStairs(int n) {
        return countWays(n, new HashMap<Integer, Integer>());
    }
}