class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            int start = i;
            int end = i;
            while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
                if(len < end-start+1){
                    len = end-start+1;
                    left = start;
                    right = end;
                }
                start--;
                end++;
            }
            
            start = i;
            end = i+1;
            while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
                if(len < end-start+1){
                    len = end-start+1;
                    left = start;
                    right = end;
                }
                start--;
                end++;
            }
        }
        return s.substring(left, right+1);
    }
}