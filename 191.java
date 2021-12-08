public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        for(int i=0;i<32;i++){
            int lastBit = (n>>i)&1;
            if(lastBit == 1)count++;
        }
        return count;
        
    }
}