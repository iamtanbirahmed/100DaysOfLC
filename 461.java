class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        for(int i=0;i<32;i++){
            int lastBit = (xor>>i) & 1;
            if(lastBit == 1)count++;
        }
        return count;
    }
}