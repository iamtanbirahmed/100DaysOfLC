class Solution {
    public int strStr(String haystack, String needle) {
        
        int len = needle.length();        
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0) 
               && (i+len) <= haystack.length() 
               && haystack.substring(i, i+len).equals(needle)){
                return i;
                
            }            
        } 
        return -1;
    }
}