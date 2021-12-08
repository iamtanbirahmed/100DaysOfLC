class Solution {
    public int meomizedClimbStairs(int n, int[] memo){
        if(memo[n]>=1)return memo[n];
        memo[n-1] = this.meomizedClimbStairs(n-1, memo);
        memo[n-2] = this.meomizedClimbStairs(n-2, memo);
        memo[n] = memo[n-1]+memo[n-2];
        return memo[n];
        
    }
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        return this.meomizedClimbStairs(n, memo);
        
    }
}