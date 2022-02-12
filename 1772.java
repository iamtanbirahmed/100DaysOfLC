class Feature{
    String name;
    Pair<Integer, Integer> pos;
    
    Feature(String name, Integer index, Integer count){
        this.name = name;
        this.pos = new Pair(index,count);
    }
    
}
class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Feature[] featArray = new Feature[features.length];
        HashMap<String, Integer> count = new HashMap();
        for(String response: responses){
            String[] res = response.split(" ");
            Set<String> resSet = new HashSet(Arrays.asList(res));
            for(String r: resSet){
                count.put(r, count.getOrDefault(r, 0)+1);
            }
        }
        
        for(int i=0;i<features.length;i++){
            featArray[i] = new Feature(features[i], i, count.getOrDefault(features[i],0));
        }
        
        Arrays.sort(featArray, (f1, f2)->{
           
            if(f1.pos.getValue() == f2.pos.getValue()){
                return Integer.compare(f1.pos.getKey(), f2.pos.getKey());
            }
            return Integer.compare(f1.pos.getValue(), f2.pos.getValue())*(-1);
            
        });
        String[] result = new String[features.length];
        for(int i=0;i<featArray.length;i++){
            result[i] = featArray[i].name;
        }
        return result;
    }
}