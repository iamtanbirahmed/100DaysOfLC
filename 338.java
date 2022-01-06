class Solution {
    private int numBits(int n){
        int count = 0;
        for(int i=0;i<32;i++){
            int lastBit = (n>>i)&1;
            if(lastBit == 1){
                count++;
            }
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++){
            result[i] = this.numBits(i);
        }
        return result;
        
    }
}