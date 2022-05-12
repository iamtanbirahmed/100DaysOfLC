class Solution {
    public String getSmallestString(int n, int k) {
        char[] nums = new char[n];
        Arrays.fill(nums, 'a');
        k-=n;
        int i = nums.length-1;
        while(k>0){
            if(k>=25){
                nums[i]+=25;
                k-=25;
            }else{
                nums[i]+=k;
                k=0;
            }
            i--;
        }
        String result = new String(nums);
        return result;
    }
}