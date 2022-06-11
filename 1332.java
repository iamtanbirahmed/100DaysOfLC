class Solution {
    
    private boolean isPalindrom(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    public int removePalindromeSub(String s) {
        if(this.isPalindrom(s))
            return 1;
        return 2;
    }
}