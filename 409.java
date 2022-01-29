class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap();
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i),0)+1);
        }
        int odd = 0;
        for(Integer value: count.values()){
            odd+=(value%2);
        }
        
        return odd>1?s.length()-odd+1:s.length();
    }
}