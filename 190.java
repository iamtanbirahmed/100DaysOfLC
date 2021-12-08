public class Solution {
    // you need treat n as an unsigned value
    
    public int reverseBits(int n) {
        int reverse  = 0;
        for(int i=0;i<32;i++){
            int lastBit = (n>>i)&1;
            reverse = (reverse<<1)|lastBit;
        }
        return reverse;
        
    }
}