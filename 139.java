class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--){
            for(String word: wordDict){
                if(s.substring(i).length()>=word.length()){
                    String sub = s.substring(i, i+word.length());
                    if(sub.equals(word)){
                        dp[i] = dp[i+sub.length()];
                        if(dp[i] == true){
                            break;
                        }
                    }
                }
            }
        }
        return dp[0];
    }
}