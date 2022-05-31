class Solution {
    public String minWindow(String s, String t) {
        int end = 0;
        int start = 0;
        Map<Character, Integer> s_count = new HashMap();
        Map<Character, Integer> t_count = new HashMap();
        
        for(char ch: t.toCharArray()){
            t_count.put(ch, t_count.getOrDefault(ch, 0)+1);
        }
        int required = t_count.size();
        int formed = 0;
        int len = Integer.MAX_VALUE;
        String result = "";
        while(end < s.length()){
            char ch = s.charAt(end);
            
            s_count.put(ch, s_count.getOrDefault(ch, 0)+1);
            if(t_count.containsKey(ch) && s_count.get(ch).intValue() == t_count.get(ch).intValue()){
                formed++;
            }
            
            while(required == formed){
                if(len > end-start+1){
                    result = s.substring(start, end+1);
                    len = end-start+1;
                }
                char ch2 = s.charAt(start);
                s_count.put(ch2, s_count.get(ch2)-1);
                
                if(t_count.containsKey(ch2) && s_count.get(ch2).intValue() < t_count.get(ch2).intValue()){
                    formed--;
                }
                start++;
            }
            end++;
        }
        
        return result;
    }
}