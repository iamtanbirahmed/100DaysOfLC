class Solution {
    
    private String ans = null;
    
    private int findLCA(HashMap<String, List<String>> graph, String root ,String r1, String r2){
        int mid = 0;
        if(root.equals(r1) == true || root.equals(r2) == true){
            mid = 1;
        }
        int found = 0;
        for(String child: graph.get(root)){
            found+=this.findLCA(graph, child, r1, r2);
        }
        if(mid+found>1){
            this.ans = root;
        }
        
        return (mid+found>=1) ? 1 : 0;
        
    }
        
    
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        HashMap<String, List<String>> graph = new HashMap();
        for(List<String> r : regions){
            for(String str: r){
                graph.put(str, new ArrayList<String>());
            }
        }
        
        for(List<String> r : regions){            
            String key = r.get(0);
            for(int i=1;i<r.size();i++){
                graph.get(key).add(r.get(i));
            }            
        }
        this.findLCA(graph, regions.get(0).get(0), region1, region2);
        return this.ans;
    }
}