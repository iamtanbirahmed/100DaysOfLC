class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group = new HashMap();
        
        for(int i=0;i<strs.length;i++){
            char[] chars  = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(group.containsKey(key) == false){
                group.put(key, new LinkedList<String>());
            }
            group.get(key).add(strs[i]);
            
        }
        
        LinkedList<List<String>> result = new LinkedList();
        for(List<String> l: group.values()){
            result.add(l);
        }
        return result;
    }
}