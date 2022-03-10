class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> count = new HashSet();
        for(int n: nums1){
            count.add(n);
        }
        Set<Integer> result = new HashSet();
        for(int n: nums2){
            if(count.contains(n)){
                result.add(n);
            }
        }
        int[] resultArray = new int[result.size()];
        int i=0;
        for(int n: result){
            resultArray[i++] = n;
        }
        
        return resultArray;
    }
}