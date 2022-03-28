class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        int[][] dp = new int[n][n];
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        result.add(List.of(dp[0][0]));
        for(int i=1;i<n;i++){
            List<Integer> row = new ArrayList();
            row.add(dp[i][0]);
            for(int j=1;j<=i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                row.add(dp[i][j]);
            }
            result.add(row);
        }
        
        return result;
    }
}