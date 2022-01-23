class Solution {
    
    private String hashValue(String str){
        char[] chars = str.toCharArray();
        int first = chars[0];
        for(int i=0;i<chars.length;i++){
            chars[i] = (char) ((((chars[i]- first)+26)%26)+'a');
        }
        return new String(chars);
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap();
        
        for(String str: strings){
            String key = this.hashValue(str);
            if(map.containsKey(key) == false){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        ArrayList<List<String>> result = new ArrayList();
        for(String key: map.keySet()){
            result.add(map.get(key));  
        }
        
        return result;
        
    }
}