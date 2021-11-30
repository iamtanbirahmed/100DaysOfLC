class Solution {
    
    private boolean isValid(char ch){
        if(ch>='A' && ch<='Z' || ch>='0' && ch<='9') return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int left= 0;
        int right = s.length()-1;
        s = s.toUpperCase();
        
        while(left<=right){
            if(this.isValid(s.charAt(left)) == false){
                left ++;
                continue;
            }
            if(this.isValid(s.charAt(right)) == false){
                right--;
                continue;
            }
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
            
        }
        
        return true;
        
        
    }
}