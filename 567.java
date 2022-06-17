class Solution {
    
    private boolean isPermutation(String s1, String s2){
        Map<Character, Integer> count = new HashMap();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            count.put(ch, count.getOrDefault(ch,0)+1);
        }
        for(int j=0;j<s2.length();j++){
            char ch2 = s2.charAt(j);
            if(count.containsKey(ch2) == false)
                return false;
            count.put(ch2, count.get(ch2)-1);
            if(count.get(ch2) == 0)
                count.remove(ch2);
        }
        
        return count.size() == 0;
        
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        
        for(int i=0;i<=s2.length()-k;i++){
            String str = s2.substring(i, i+k);
            if(this.isPermutation(str, s1))
                return true;
        }
        
        return false;
    }
}