class Solution {
    public int getSum(int a, int b) {
        int aBit = 0;
        int bBit = 0;
        int bitNum = 0;
        int carry = 0;
        int sum = 0;
        while(bitNum < 32){
            aBit = (a>>bitNum) & 1;
            bBit = (b>>bitNum) & 1;
            int mask = aBit^bBit^carry;
            sum|=(mask << bitNum);
            carry = (aBit & bBit) | (carry & (aBit^bBit));
            // a = a>>1;
            // b = b>>1;
            bitNum++;
             
        }
        return sum;
        
    }
}