class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap();
        int start = 0;
        int end = 0;
        
        int max = 0;
        
        while(end< s.length()){
            char ch = s.charAt(end);
            count.put(ch, count.getOrDefault(ch,0)+1);
            
            while (((end-start+1) - Collections.max(count.values())) > k){
                char ch2 = s.charAt(start);
                count.put(ch2, count.get(ch2)-1);
                start++;
            }
            
            max = Math.max(max, (end-start+1));
            end++;
        }
        
        return max;
    }
}