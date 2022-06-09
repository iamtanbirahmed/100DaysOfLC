class Solution {
    
    private int findRotation(int[] tops, int[] bottoms){
        Map<Integer, Integer> count = new HashMap();
        for(int n: tops){
            count.put(n, count.getOrDefault(n,0)+1);
        }
        Map.Entry<Integer, Integer> e = Collections.max(count.entrySet(), (e1, e2)->{
            return e1.getValue() - e2.getValue();
        });
        
        int maxValue = e.getKey();
        int rotation = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==maxValue)
                continue;
            if(bottoms[i]!=maxValue)
                return -1;
            rotation++;
        }
        
        return rotation;
        
    }
    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top_max = this.findRotation(tops, bottoms);
        int bottom_max = this.findRotation(bottoms, tops);
        if(top_max<0) return bottom_max;
        if(bottom_max < 0) return top_max;
        
        return Math.min(bottom_max, top_max);
    }
}