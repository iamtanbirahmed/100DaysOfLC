class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length-1;
        int count = 0;
        Arrays.sort(people);
        while(left<=right){
            count++;
            int rem = limit-people[right];
            right--;
            if(rem >= people[left]){
                left++;
            }            
        }
        
        return count;
    }
}