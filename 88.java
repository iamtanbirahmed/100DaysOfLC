class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] dp = new int[m+n];
        int index = 0;
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]< nums2[j]){
                dp[index++] = nums1[i++];
            }else{
                dp[index++] = nums2[j++];
            }
        }
        while(i<m){
            dp[index++] = nums1[i++];
        }
        
        while(j<n){
            dp[index++] = nums2[j++];
        }
        for(i=0;i<(m+n);i++){
            nums1[i] = dp[i];
        }
        
    }
}