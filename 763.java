class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap();
        for(int i=0;i<s.length();i++){
            lastIndex.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        int total = 0;
        List<Integer> result = new LinkedList();
        while(start<s.length()){
            char ch = s.charAt(start);
            int index = lastIndex.get(ch);
            end = Math.max(end, index);
            if(end == start){
                int len = start-total+1;
                result.add(len);
                total = start+1;
            }
            start++;
        }
        
        
        return result;
    }
}