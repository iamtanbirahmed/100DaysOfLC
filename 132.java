class Solution {
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    private int dfs(int index, String s, Map<Integer, Integer> cache){
        if(index>=s.length()){
            return 0;         
        }
        if(cache.containsKey(index))
            return cache.get(index);
        int min = Integer.MAX_VALUE;
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)){                
                min = Math.min(min,1+this.dfs(i+1, s, cache));
            }
        }
        cache.put(index, min);
        return min;
    }
    public int minCut(String s) {
        
        return dfs(0, s, new HashMap())-1;
    }
}