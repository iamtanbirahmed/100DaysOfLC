class Solution {
    public boolean isSubsequence(String s, String t) {
        int required = s.length();
        int formed = 0;
        
        int i =0;
        int j = 0;
        while(i< t.length()){
            char ch = t.charAt(i);
            if(j< s.length() && s.charAt(j) == ch){
                formed++;
                j++;
            }
            i++;
        }
        
        return (required == formed);
    }
}