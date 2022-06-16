class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int left= i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if((right-left +1) > len){
                    len = right-left+1;
                    end = right;
                    start = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if((right-left +1) > len){
                    len = right-left+1;
                    end = right;
                    start = left;
                }
                left--;
                right++;
            }
        }
        
        return s.substring(start, end+1);
    }
}