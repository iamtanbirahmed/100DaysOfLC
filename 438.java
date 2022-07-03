class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new LinkedList<Integer>();
        int len = p.length();
        
        Map<Character, Integer> sCount = new HashMap();
        Map<Character, Integer> pCount = new HashMap();
        List<Integer> result = new LinkedList();
        
        for(int i=0;i<len;i++){
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i),0)+1);
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0;
        if(sCount.equals(pCount)) result.add(left); 
        for(int i=len;i<s.length();i++){
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0)+1);
            
            char ch2 = s.charAt(left);
            sCount.put(ch2, sCount.get(ch2)-1);
            if(sCount.get(ch2) == 0)
                sCount.remove(ch2);
            left++;
            if(pCount.equals(sCount))
                result.add(left);
        }
        
        return result;
        
    }
}