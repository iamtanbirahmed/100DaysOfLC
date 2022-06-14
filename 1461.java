class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = 1<<k;
        Set<String> seen = new HashSet();
        for(int i=0;i<=s.length()-k;i++){
            String str = s.substring(i, i+k);
            if(seen.contains(str) == false){
                seen.add(str);
                required--;
                if(required == 0)
                    return true;
            }
        }
        
        return false;
    }
}