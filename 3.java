class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> count = new HashMap();
        int len = 0;
        while(end<s.length()){
            char ch = s.charAt(end);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            
            while(count.get(ch)>1){
                char ch2 = s.charAt(start);
                count.put(ch2, count.get(ch2)-1);
                start++;
            }
            len = Math.max(len, end-start+1);
            end++;
        }
        
        return len;
    }
}