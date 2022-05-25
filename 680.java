class Solution {
    
    private boolean isValid(int left, int right, String s){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return this.isValid(left+1, right, s) || this.isValid(left, right-1, s);
            }
            left++;
            right--;
        }
        
        return true;
    }
}