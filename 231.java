class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int rem = 0;
        while(n>1){
            rem = n%2;
            n = n/2;
            if(rem == 1){
                return false;
            }
        }
        
        return true;
    }
}