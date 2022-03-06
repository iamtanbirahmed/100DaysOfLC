class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> count = new HashMap();
        int start = 0;
        int end = 0;
        int max =  0;
        while(end < s.length()){
            char ch1 = s.charAt(end);
            count.put(ch1, count.getOrDefault(ch1,0)+1);
            while(count.get(ch1)>1){
                char ch2 = s.charAt(start);
                count.put(ch2, count.get(ch2)-1);
                start++;
            }
            max = Math.max(end-start+1, max);
            end++;
        }
        
        return max;
    }
}