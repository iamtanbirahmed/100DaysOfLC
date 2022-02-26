class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int resLen = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            // for odd string length
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > resLen){
                    resLen = right-left+1;
                    start = left;
                    end = right;
                }
                left--;
                right++;                
            }
            // for even string length
            left = i;
            right =i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > resLen){
                    resLen = right-left+1;
                    start = left;
                    end = right;
                }
                left--;
                right++;                
            }
        }
        return s.substring(start, end+1);
    }
}