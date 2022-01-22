class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            count+=this.expandFromMiddle(i,i, str);
            count+=this.expandFromMiddle(i, i+1, str);
        }
        return count;
    }
    
    private int expandFromMiddle(int left, int right, char[] s){
        int count = 0;
        
        while(left>=0 && right<s.length && s[left] == s[right]){
            count++;
            left--;
            right++;
        }
        return count;
    }
}