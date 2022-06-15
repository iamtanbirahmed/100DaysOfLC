class Solution {
    private boolean is1editDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int i=0;
        while(i<m){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.substring(i+1).equals(s2.substring(i)) == false && s1.substring(i).equals(s2.substring(i+1)) == false){
                    return false;
                }
            }
            i++;
        }
        return (n-m) == 1;
        
    }
    
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (s1, s2)->{
           return s1.length() - s2.length(); 
        });
        int max = 1;
        for(int i=words.length-2;i>=0;i--){
            for(int j=i;j<words.length;j++){
                if(this.is1editDistance(words[i], words[j])){
                    dp[i] = Math.max(dp[i], dp[j]+1);    
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}